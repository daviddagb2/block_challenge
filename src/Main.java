import models.Block;
import models.Factory;
import models.Truck;

public class Main {

    public static void main(String[] args){

        System.out.println("Hello World");

        //Create Factory
        Factory factory = new Factory();

        //Create Blocks
        Block block0 = new Block(new int[][]{
                {1,0,0},
                {1,1,0},
                {1,1,1}
        });

        Block block1 = new Block(new int[][]{
                {1,1,1},
                {0,0,0},
                {0,0,0}
        });

        Block block2 = new Block(new int[][]{
                {1,0,0},
                {1,1,0},
                {1,0,0}
        });

        Block block3 = new Block(new int[][]{
                {1,1,0},
                {1,1,0},
                {1,0,0}
        });

        //create the truck
        Truck truck = new Truck();

        //Add the truck to the factory
        factory.onTruckArrived(truck);

        //Print the blocks
        System.out.print(block0.toString());
        System.out.print(block1.toString());
        System.out.print(block2.toString());
        block0.rotate();

        // Test adding blocks
        factory.onBlockProduced(block0);
        factory.onBlockProduced(block1);
        factory.onBlockProduced(block2);
        factory.onBlockProduced(block3);
        factory.onBlockProduced(block3);

    }
}
