public class Nursery
{
public static void main(String args[ ])
{
  int n,N=4;
  for(n=N;n>2;n--)
 {
   System.out.println( n+"bottles of beer on the wall,"+n+"bottles of beer.");
   System.out.println("Take one down,pass it around.");
   System.out.println( n-1+"bottles of beer on the wall.");
 }
 if(n==2)
{
 System.out.println( n+"bottles of beer on the wall,"+n+"bottles of beer.");
 System.out.println("Take one down,pass it around.");
 System.out.println( n-1+"bottle of beer on the wall.");
  n=n-1;
}
System.out.println( n+"bottle of beer on the wall,"+n+"bottle of beer.");
System.out.println("Take one down,pass it around.");
System.out.println("No more bottles of beer on the wall.");

}
}