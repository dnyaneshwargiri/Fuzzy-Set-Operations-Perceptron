import java.util.*;
class FuzzySet
{
 float num[];
 float den[];
 int N;
 FuzzySet(int n)
 {
 N = n;
 num = new float[n];
 den = new float[n];
 }
 Scanner sc = new Scanner(System.in);
 FuzzySet()
 {
 System.out.println("Enter The No. Of Elements : ");
 N = sc.nextInt();
 num = new float[N];
 den = new float[N];
 System.out.println("Enter Elements : ");
 for(int i=0;i<N;i++)
 {
 System.out.println("Enter Numerator : ");
 num[i] = sc.nextFloat();
 System.out.println("Enter Denominator : ");
 den[i] = sc.nextFloat();
 }
 }
 public void showSet()
 {
 System.out.print("{ ");
 for(int i=0;i<N;i++)
 {
 System.out.print(num[i]+"/"+den[i]+" ");
 }
 System.out.print(" }");
 }
}
public class FuzzyOperations
{
 static void Union(FuzzySet A, FuzzySet B, FuzzySet C)
 {
 int flag =0;
 int cnt =0,j,i;
 for(i=0;i<A.N;i++)
 {
 flag = 0;
 for(j=0;j<B.N;j++) 
 {
 if(A.den[i] == B.den[j])
 {
 flag =1;
 break;
 }
 }
 if(flag == 1)
 {
 if(A.num[i]>B.num[j])
 {
 C.num[cnt] = A.num[i];
 C.den[cnt] = A.den[i];
 cnt++;
 }
 else
 {
 C.num[cnt] = B.num[j];
 C.den[cnt] = B.den[j];
 cnt++;
 }
 }
 }
 for(i=0;i<A.N;i++)
 {
 flag = 0;
 for(j=0;j<cnt;j++)
 {
 if(A.den[i] == C.den[j])
 {
 flag=1;
 break;
 }
 }
 if(flag == 0)
 {
 C.num[cnt] = A.num[i];
 C.den[cnt] = A.den[i];
 cnt++;
 }

 }
 for(i=0;i<B.N;i++)
 {
 flag = 0;
 for(j=0;j<cnt;j++)
 {
 if(B.den[i] == C.den[j])
 {
 flag=1;
 break;
 } 
 }
 if(flag == 0)
 {
 C.num[cnt] = B.num[i];
 C.den[cnt] = B.den[i];
 cnt++;
 }

 }
 C.N = cnt;
 }

 static void Intersection(FuzzySet A, FuzzySet B, FuzzySet C)
 {

 int flag =0;
 int cnt =0,j,i;
 for(i=0;i<A.N;i++)
 {
 flag = 0;
 for(j=0;j<B.N;j++)
 {
 if(A.den[i] == B.den[j])
 {
 flag =1;
 break;
 }
 }
 if(flag == 1)
 {
 if(A.num[i]<B.num[j])
 {
 C.num[cnt] = A.num[i];
 C.den[cnt] = A.den[i];
 cnt++;
 }
 else
 {
 C.num[cnt] = B.num[j];
 C.den[cnt] = B.den[j];
 cnt++;
 }
 }
 }
 for(i=0;i<A.N;i++)
 {
 flag = 0;
 for(j=0;j<cnt;j++)
 {
 if(A.den[i] == C.den[j])
 {
 flag=1; 
 break;
 }
 }
 if(flag == 0)
 {
 C.num[cnt] = A.num[i];
 C.den[cnt] = A.den[i];
 cnt++;
 }

 }
 for(i=0;i<B.N;i++)
 {
 flag = 0;
 for(j=0;j<cnt;j++)
 {
 if(B.den[i] == C.den[j])
 {
 flag=1;
 break;
 }
 }
 if(flag == 0)
 {
 C.num[cnt] = B.num[i];
 C.den[cnt] = B.den[i];
 cnt++;
 }

 }
 C.N = cnt;
 }
 static void Complement(FuzzySet A, FuzzySet C)
 {

 for(int i=0;i<A.N;i++)
 {
 C.num[i] = 1 - A.num[i];
 C.den[i] = A.den[i];
 }
 C.N = A.N;
 }
 public static void main(String[] args)
 {
 FuzzySet A,B,U,I,AC,BC;
 A = new FuzzySet();
 B = new FuzzySet();


 U = new FuzzySet(A.N+B.N);
 I = new FuzzySet(A.N+B.N);
 AC = new FuzzySet(A.N+B.N); 
 BC = new FuzzySet(A.N+B.N);

 System.out.println("\nSet A is : ");
 A.showSet();
 System.out.println("\nSet B is : ");
 B.showSet();

 System.out.println("\n\nAUB is : ");
 Union(A,B,U);
 U.showSet();

 System.out.println("\n\nA intersection B is : ");
 Intersection(A,B,I);
 I.showSet();

 System.out.println("\n\nA complement is : ");
 Complement(A,AC);
 AC.showSet();

 System.out.println("\n\nB complement is : ");
 Complement(B,BC);
 BC.showSet();

 System.out.println("\n\nA-B (A|B) : ");
 Intersection(A,BC,I);
 I.showSet();

 System.out.println("\n\nB-A (B|A) : ");
 Intersection(B,AC,I);
 I.showSet();
 }
}
