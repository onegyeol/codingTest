package practice;
/*
 * Order 객체는 id, status (NEW, PROCESSING, COMPLETED, CANCELLED)를 가진다.
 * OrderProcessor 인터페이스를 정의하고, process(Order order) 메소드를 갖는다.CreditCardOrderProcessor, PayPalOrderProcessor 같은 구현체가 존재한다.
같은 주문을 여러 번 처리 요청할 수 있지만, 최초 1회만 처리되고 이후는 무시해야 한다.
멀티스레드 환경에서도 동작해야 한다.
 */

interface OrderProcessor {
    public void process(Order order);
}

public class test {
    public static void main(String[] args) {
        Order order = new Order(1001, "NEW");
        OrderProcessor processor = new CreditCardOrderProcessor();
        Thread t1 = new Thread(() -> processor.process(order));
        Thread t2 = new Thread(() -> processor.process(order));
        t1.start();
        t2.start();
    }
}
class CreditCardOrderProcessor implements OrderProcessor{

    @Override
    public void process(Order order) {
        synchronized(order){
            if(!order.isProcessed()){
                System.out.println("Order" + order.id + " is processed by CreditCard");
                order.setProcessed(true);
            }
        }
        
    }
    
}

class PayPalOrderProcessor implements OrderProcessor{

    @Override
    public void process(Order order) {
        synchronized(order){
            if(!order.isProcessed()){
                System.out.println("Order" + order.id + " is processed by PayPal");
                order.setProcessed(true);
            }
        }
        
    }
    
}

class Order{
    int id;
    String status;
    private boolean processed = false;

    public Order(int id, String status){
        this.id = id;
        this.status = status;
    }

    public boolean isProcessed(){
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
