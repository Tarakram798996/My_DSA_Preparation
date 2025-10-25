public class FractionalKnapsack {
    static int[] val;
    static int[] wt;
    static int cap;
    public static void sort(int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                double r1= (double) val[j]/wt[j];
                double r2= (double) val[j+1]/wt[j+1];
                if(r1<r2){
                    int t1=val[j]; val[j]=val[j+1]; val[j+1]=t1;
                    int t2=wt[j]; wt[j]=wt[j+1]; wt[j+1]=t2;
                }
            }
        }
    }
    public static double fracKnap(int n){
        double res=0;
        int i=0;
        while(i<n && cap>=wt[i]){
            cap-=wt[i];
            res+=val[i];
            i++;
        }
        if(cap>0){
            double ratio = (double) cap/wt[i];
            res+=val[i]*ratio;
        }
        return res;
    }
    public static void main(String args[]){
        val=new int[]{60, 100, 120};
        wt=new int[]{10,20,30};
        cap=50;
        int n=3;
        sort(n);
        double res=fracKnap(n);
        System.out.println("Result :: "+res);
    }
}
