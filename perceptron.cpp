
#include<iostream>
using namespace std;

int main()
{
    int x1[]={0,0,1,1};int x2[]={0,1,0,1};
    //int a[4][2]={{0,0},{0,1},{1,0},{1,1}};
    int t[]={0,0,0,1},yin,y[4];
    int theta=0,alpha=1;
    int w1=1,w2=1,b=-1,dw1,dw2,db;
    cout<<"X1\tX2\tT\tYin\tY\tDW1\tDW2\tDbias\tW1\tW2\tBias\n\n";
    for(int i=0;i<=3;i++)
    {
        yin=0;
        yin=b+(x1[i]*w1)+(x2[i]*w2);
        if(yin>theta)
        {
            y[i]=1;
        }
        else
        y[i]=0;
        
        if(y[i]==t[i])
        {
            dw1=0;dw2=0;db=0;
        }
        else
        {
            dw1=alpha*t[i]*x1[i];
            dw2=alpha*t[i]*x2[i];
            db=alpha*t[i];
        }
        w1=w1+dw1;
        w2=w2+dw2;
        b=b+db;
        cout<<x1[i]<<"\t"<<x2[i]<<"\t"<<t[i]<<"\t"<<yin<<"\t"<<y[i]<<"\t"<<dw1<<"\t"<<dw2<<"\t"<<db<<"\t"<<w1<<"\t"<<w2<<"\t"<<b<<"\n";
        cout<<"\n";
        
    }
    
}
