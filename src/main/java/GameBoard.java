import java.util.Random;

public class GameBoard {
    int originNumber[10];
    int userNumber[3];
    int strike;
    int ball;
    Random random;

    /*
    public void gameInitialize(){
        for(int i=0; i<10; i++){
            originNumber[i] = '\0';
        }
        for(int i=0; i<3; i++){
            userNumber[i] = '\0';
        }
        strike = 0;
        ball = 0;
    }
    */

    // ex> 난수 326일 경우, originNum[3]=0, originNum[2]=1, originNum[6]=2
    public void setOriginNumber(){
        random = new Random();
        random.setSeed(System.currentTimeMillis());
        for(int i=0; i<3; i++){
            originNumber[random.nextInt(9)] = i;
        }
    }

    //InputView -> main -> GameBoard
    public void setUserNumber(int[] userNumber){
        for(int i=0; i<3; i++){
            this.userNumber[i] = userNumber[i];
        }
    }

    public void compareStart(){
        for(int i=0; i<3; i++){
            compareNumbers(i);
        }
    }

    public void compareNumbers(int i){
        if(this.originNumber[this.userNumber[i]]==i){
            strike++;
            continue; //이거 compareStart의 for문에서 반영하는지 확인필요
        }
        if(this.originNumber[this.userNumber[i]]!='\0'){
            ball++;
        }
    }

    public int getStrike(){
        return strike;
    }

    public int getBall(){
        return ball;
    }


    /*
    public void compareNumbers(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(userNumber[i]==originNumber[j]){
                    if(i==j){
                        strike++;
                        continue;
                    }
                    ball++;
                }
            }
        }
    }
    */

}
