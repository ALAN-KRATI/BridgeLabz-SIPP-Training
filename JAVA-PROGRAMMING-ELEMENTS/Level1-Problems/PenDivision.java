public class PenDivision{
    public static void main(String[] args){
        int pens = 14;
        int students = 3;
        int pensPerStudent = pens / students;
        int remainingPens = pens % students;

        System.out.println("The pens per student is " + pensPerStudent + " and the remaining pens not distributed is " + remainingPens);
    }
}