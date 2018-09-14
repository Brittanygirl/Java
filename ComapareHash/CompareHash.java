public class CompareHash
{
public void main(String[]args)
{
  String a="A flower on a stranger";
  System.out.println(a);
  String c=a;
  System.out.println(c);
  int hash1,hash2,hash3;
  hash1=System.identityHashCode(a);
  hash2=System.identityHashCode(c);
  System.out.println("the address of a is :",+hash1);
  System.out.println("the address of a is :",+hash2);
  c="can slowly return";
  System.out.println(c);
  hash3=System.identityHashCode(c);
 System.out.println("the address of a is :",+hash3);
}
}
