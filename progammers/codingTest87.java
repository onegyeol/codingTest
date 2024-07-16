package progammers;

import java.util.Arrays;

/**
 * 
 * 프로그래머스 Lv.2 파일명 정렬
 * 
 * 무지는 단순한 문자 코드 순이 아닌, 파일명에 포함된 숫자를 반영한 정렬 기능을 저장소 관리 프로그램에 구현하기로 했다.

소스 파일 저장소에 저장된 파일명은 100 글자 이내로, 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")만으로 이루어져 있다. 
파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.

파일명은 크게 HEAD, NUMBER, TAIL의 세 부분으로 구성된다.

HEAD는 숫자가 아닌 문자로 이루어져 있으며, 최소한 한 글자 이상이다.
NUMBER는 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있으며, 앞쪽에 0이 올 수 있다. 
0부터 99999 사이의 숫자로, 00000이나 0101 등도 가능하다.
TAIL은 그 나머지 부분으로, 여기에는 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다.

*/

public class codingTest87 {
    public String[] solution(String[] files) {
        //tail 부분은 정렬할 때 필요하지 않기에 저장하지 않음
        class File{
            String head;
            int number;
            String original; //원본 파일명 저장위해

            File(String head, int number, String original){
                this.head = head;
                this.number = number;
                this.original = original;
            }
        }
        
        File[] readFile = new File[files.length];
        
        for(int i=0; i<files.length; i++){
            String file = files[i];
            int headEnd = 0; 
            int numberStart = 0;
            int numberEnd = 0;
            
            while(headEnd<file.length()
                  && !Character.isDigit(file.charAt(headEnd))){ //숫자가 나오기 전까지 head에 저장
                headEnd++;
            }
            
            numberStart = headEnd;
            numberEnd = numberStart;
            
            while(numberEnd<file.length()
                  && Character.isDigit(file.charAt(numberEnd))){ //숫자이면 number에 저장
                numberEnd++;
            }
            
            String head = file.substring(0, headEnd);
            int number = Integer.parseInt(file.substring(numberStart, numberEnd)); //숫자는 문자로 정렬하지 않고 9<10 숫자순서대로 정렬위해
            
            readFile[i] = new File(head, number, file);            
        }
        
        Arrays.sort(readFile, (a, b) -> {
            int headCompare = a.head.toLowerCase().compareTo(b.head.toLowerCase()); //1차적으로 head로 정렬
            if(headCompare != 0){
                return headCompare; //head로 정렬되면 끝
            } 
            return a.number - b.number; //head의 문자열이 똑같으면 숫자로 정렬
            
        });
        
        String[] answer = new String[files.length];
        for(int i=0; i<readFile.length; i++){
            answer[i] = readFile[i].original;
        }
        
        return answer;
    }
}
