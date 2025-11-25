public class OrderThread extends Thread {

    private Product product;

    public OrderThread(Product product){
        this.product = product;
    }

    @Override
    public synchronized void run(){
        System.out.println("Processing Order for: " + product.getName());

        double discountedPrice = product.applyDiscount(product.getPrice());

        System.out.println("Original Price: " + product.getPrice());
        System.out.println("Cyber Monday Price: " + discountedPrice);

        try{
            Thread.sleep(2000);
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println("Order Placed Successfully!\n");
    }
}
