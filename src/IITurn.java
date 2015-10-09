import java.util.Random;
public class IITurn {

    public void turnComputer(int firstTurn,char[][] fieldArray)
    {
        boolean turnOK=false;
        int matches=0;
        boolean matchesB=false;

        char[] gorizont=new char[]{' ',' ',' '};
        int i,j=0;
        for ( i=0;i<fieldArray.length;i++){
            for (j=0;j<fieldArray.length;j++){
                matches++;
                gorizont[j]=(char)j;
            }
            if ((matches==2)&&(gorizont[1]!=' ')&&(fieldArray[i][j])!='X'){
                if (gorizont[2]!='0'){
                    fieldArray[i][2]='0';
                    matchesB=true;
                    break;
                }
                if (gorizont[0]!='0'){
                    fieldArray[i][0]='0';
                    matchesB=true;
                    break;
                }
            }
        }
        if (matchesB==false) {
            Random random = new Random();
            int randI, randJ;
            while (turnOK == false) {
                randI = random.nextInt(3);
                randJ = random.nextInt(3);
                if ((fieldArray[randI][randJ] != 'X') && (fieldArray[randI][randJ] != '0')) {
                    fieldArray[randI][randJ] = '0';
                    turnOK = true;
                    //System.out.println("Log:CompTurn: "+randI+","+randJ);
                }
            }
        }
    }

    public void FirstCompTurn(char[][] fieldArray){
        boolean turnOK=false;
        Random random = new Random();
        int randI, randJ;
        while (turnOK == false) {
            randI = random.nextInt(3);
            randJ = random.nextInt(3);
            if ((fieldArray[randI][randJ] != 'X') && (fieldArray[randI][randJ] != '0')) {
                fieldArray[randI][randJ] = '0';
                turnOK = true;
               // System.out.println("Log:CompTurn: "+randI+","+randJ);
            }
        }
    }
}
