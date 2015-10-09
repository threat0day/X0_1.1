public class DefineWinner {

    public int Gorizont(char[][] fieldArray,char[] turn){
        int counter=0;
        for(int i=0;i<fieldArray.length;i++){
            for(int j=0;j<fieldArray.length;j++){
                if (fieldArray[i][j]==turn[0]) counter++;
            }
            if (counter==3) {
                return counter;
            }
            else
            {
                counter=0;
            }
        }
        return counter;
    }
    public int DiagonalLeft(char[][] fieldArray,char[] turn){
        int counter=0;
        int j=0;
        for(int i=0;i<fieldArray.length;i++,j++){
            if (fieldArray[i][j]==turn[0]) counter++;
        }
        return counter;
    }
    public int DiagonalRight(char[][] fieldArray,char[] turn,int size){
        int counter=0;
        int j=size-1;
        for(int i=0;i<size;i++){
            if (fieldArray[i][j]==turn[0]) counter++;
            j--;
        }
        return counter;
    }

}
