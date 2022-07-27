package models;

public class Block { // You may modify this

    int configuration[][]={
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };

    public Block(){

    }

    public Block(int[][] configuration){
        this.configuration = configuration;
    }

    public void destroy() {
        configuration = new int[][]{
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
    }

    public void rotate(){
        int dim = this.configuration.length;

        for (int i=0; i <= (dim - 1)/2; i++) {
            for (int j=i; j < dim - i - 1; j++) {
                int p1 = this.configuration[i][j];
                int p2 = this.configuration[j][dim-i-1];
                int p3 = this.configuration[dim-i-1][dim-j-1];
                int p4 = this.configuration[dim-j-1][i];

                this.configuration[j][dim-i-1] = p1;
                this.configuration[dim-i-1][dim-j-1] = p2;
                this.configuration[dim-j-1][i] = p3;
                this.configuration[i][j] = p4;
            }
        }
    }


    public boolean checkCanCombine(Block other){
        int rotation = 0;
        boolean canCombine = true;
        Block tempBlock = other;

        do{
            //check x
            for(int i =0; i<tempBlock.configuration.length; i++){
                //check y
                for(int j =0; j< tempBlock.configuration[i].length; j++){
                    if(tempBlock.configuration[i][j] == 1 && this.configuration[i][j] ==1){
                        canCombine = false;
                        break;
                    }
                }//End for y
                if(canCombine == false){
                    continue;
                }
            }//End for x
            rotation++;

            //rotate to check availability
            tempBlock.rotate();
        }while(rotation <=3 && canCombine == false);
        return canCombine;
    }


    public Block combinateBlock(Block other){
        int rotation = 0;
        boolean canCombine = true;
        Block tempBlock = other;

        //result block
        Block newBlock = new Block();

        do{
            //check x
            for(int i =0; i<tempBlock.configuration.length; i++){
                //check y
                for(int j =0; j< tempBlock.configuration[i].length; j++){
                    if(tempBlock.configuration[i][j] == 1 && this.configuration[i][j] ==1){
                        canCombine = false;
                        break;
                    }else{
                        if(tempBlock.configuration[i][j] == 0 && this.configuration[i][j] == 1 ||
                           tempBlock.configuration[i][j] == 1 && this.configuration[i][j] == 0 ){
                            newBlock.configuration[i][j] = 1;
                        }
                    }
                }//End for y
                if(canCombine == false){
                    continue;
                }
            }//End for x
            rotation++;

            if(canCombine == true){
                return newBlock;
            }

            //rotate to check availability
            tempBlock.rotate();
        }while(rotation <=3);
        return null;
    }

    //Added this to print matrix
    public String toString(){
        String result = "";
        result += "\n";
        for(int i=0; i< this.configuration.length; i++){
            result += "\n";
            for(int j=0; j< this.configuration[i].length; j++){
                result += this.configuration[i][j] + " ";
            }
        }
        return result;
    }
}