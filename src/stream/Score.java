package stream;

public class Score{
    int kor;
    int eng;
    int math;

    Score(int kor, int eng, int math){
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    int getKor(){ return kor; }
    int getEng(){ return eng; }
    int getMath(){ return math; }
}
