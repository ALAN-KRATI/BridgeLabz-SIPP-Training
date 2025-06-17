public class ProfitLoss{
    public static void main(String[] args){
        int cp = 129, sp = 191, p = 0;
        p = sp - cp;
        int pp = (p * 100)/cp;
        System.out.println("The Cost Price is INR " + cp + " and Selling Price is INR " + sp);
        System.out.println("The Profit is INR " + p + " and Profit Percentage is " + pp + "%");
    }
}