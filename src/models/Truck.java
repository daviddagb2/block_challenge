package models;

import java.util.ArrayList;
import java.util.List;

public class Truck {

    int truckspaces[][]={
            {0,0,0,0,0,0,0,0,0,},
            {0,0,0,0,0,0,0,0,0,},
            {0,0,0,0,0,0,0,0,0,}
    };

    List<Block> blocks = new ArrayList<Block>();

    public void load(Block block) {
        //is the last index
        int lastx = truckspaces[0].length-1;

        boolean continuesearching = true;

        //Function to search last space of X
        for(int i=0; i<truckspaces.length; i++){
            //get index
            for(int j=0; j<truckspaces[i].length; j++){
                if(truckspaces[i][j] == 1 && continuesearching){
                    lastx = j-1;
                    continuesearching=false;
                }
            }
        }

        if(lastx > 0){
            int lastindexstart = lastx-2;
            for(int i = 0; i< truckspaces.length; i++){
                var jc = 0;
                for(int j =lastindexstart; j<= lastx; j++){
                    truckspaces[i][j] = block.configuration[i][jc];
                    jc++;
                }
            }
        }

        blocks.add(block);

    }

    public boolean isFull() { // can be modified
         return  blocks.size() == 3 ? true : false;
    }


    public String toString(){
        String result = "";
        result += "\n";
        for(int i=0; i< this.truckspaces.length; i++){
            result += "\n";
            for(int j=0; j< this.truckspaces[i].length; j++){
                result += this.truckspaces[i][j] + " ";
            }
        }
        return result;
    }

}
