import java.util.Scanner;

public class Field {
    public final int SIZE_DEFAULT =3;
    public char[][] fieldArray=new char[SIZE_DEFAULT][SIZE_DEFAULT];
    public int defaultChar=1;
    public int GameOver=0;
    public boolean Standoff=false;
    public boolean StartGame=false;
    public char[] turn=new char[]{'X'};
    public char[] turnX0=new char[1];
    public int counter=0;


   Field(){//конструктор, заполняем поле цифрами
       String bufString=new String();
        for(int i=0;i<fieldArray.length;i++)
            for(int j=0;j<fieldArray.length;j++){
                bufString=Integer.toString(defaultChar);
               fieldArray[i][j]=bufString.charAt(0);
               defaultChar++;
            }
    }

    public void ReferField() {
        for (int i = 0; i < fieldArray.length; i++) {
            for (int j = 0; j < fieldArray.length; j++) {
                System.out.print("["+fieldArray[i][j]+"]");
            }
          System.out.println();
        }
    }

    public void InputTurn(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Turn("+turn[0]+") Input number for turn:");
            turnX0=scanner.nextLine().toCharArray();
        if ((turn[0]=='X')&&GameOver==0){
            PlayerTurn();
        }
        if ((turn[0]=='0')&&GameOver==0){
            CompTurn();
        }
    }
    public void PlayerTurn(){
        for (int i=0;i<fieldArray.length;i++){
            for (int j=0;j<fieldArray.length;j++){
                if ((fieldArray[i][j]==turnX0[0])&&(fieldArray[i][j]!='X')&&(fieldArray[i][j]!='0')){
                    fieldArray[i][j]='X';
                    GameProcess();
                    turn[0]='0';
                    System.out.println("Log: PlayerTurn");
                }
            }
        }
    }
    public void CompTurn(){
        for (int i=0;i<fieldArray.length;i++){
            for (int j=0;j<fieldArray.length;j++){
                if ((fieldArray[i][j]==turnX0[0])&&(fieldArray[i][j]!='X')&&(fieldArray[i][j]!='0')){
                    fieldArray[i][j]='0';
                    GameProcess();
                    turn[0]='X';
                    System.out.println("Log: CompTurn");
                }
            }
        }
    }


    public void GameProcess(){
        DefineWinner defineWinner =new DefineWinner();
        counter++;

        if (counter==SIZE_DEFAULT*SIZE_DEFAULT){
            System.out.println("------------------");
            System.out.println("Standoff");
            Standoff=true;
        }

        if (defineWinner.Gorizont(fieldArray,turn)==3){
            System.out.println("Gorizont Winer "+turn[0]);
            GameOver=1;
        }
        if (defineWinner.DiagonalLeft(fieldArray, turn)==3){
            System.out.println("Left Winer "+turn[0]);
            GameOver=1;
        }
        if (defineWinner.DiagonalRight(fieldArray, turn,SIZE_DEFAULT)==3){
            System.out.println("Right Winer "+turn[0]);
            GameOver=1;
        }
        //примерно тут можно вызвать конструктор для перезапуска игры.
    }



    public void GameBegin(){
        System.out.println("Game Begin");
        do{
            ReferField();
            InputTurn();
        }while((GameOver==0)&&(Standoff==false));

    }
}
