package models;

import java.util.ArrayList;
import java.util.List;

public class Factory { // You may modify our factory to be more efficient.

    List<Truck> trucks = new ArrayList<Truck>();

    Block currentBlock = null;

    public void onTruckArrived(Truck truck) { // does not need to be modified
        trucks.add(truck);
    }

    // This function represents the conveyor belt producing blocks. Every time a block is produced, onBlockProduced() is called.
    // We would like to modify the factory to handle onBlockProduced() better.
    public void onBlockProduced(Block block) {

        // Add only if trucks available
        if(trucks.size() > 0){

            if(currentBlock == null){
                currentBlock = block;
            }else{

                boolean cancombine = currentBlock.checkCanCombine(block);

                //check if combine block
                if(cancombine){
                    currentBlock = currentBlock.combinateBlock(block);
                }

                //Add to truck
                Truck truck = trucks.get(0);
                if (truck != null) {

                    truck.load(currentBlock);
                    System.out.println(truck.toString());
                    if (truck.isFull()) {
                        trucks.remove(truck);
                    }
                } else {
                    block.destroy(); // this is a wasted block because we could not load into a truck.
                }

                currentBlock = block;
            }//end else if not null

        }else {
            block.destroy(); // this is a wasted block because we could not load into a truck.
        }


    }

}
