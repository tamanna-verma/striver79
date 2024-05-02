class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        int[][] visited = new int [n][m];
        int ans=0;

        Queue<Pair> queue = new LinkedList<Pair>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visited[i][j]=1;
                    queue.add(new Pair(i , j , 0));
                }
            }
        }
        // to mtlb i have added all the points where it was 2 
         int []dx = {0 ,0, +1 ,-1};
         int []dy = {+1, -1, 0, 0 };
        while(!queue.isEmpty()){
                //now we have all the 4 points where we can edit 
              Pair popped = queue.remove();
              int x = popped.x;
              int y = popped.y;
              int time = popped.time;
              grid[x][y]=2;
              
              ans=time;
              for(int i=0;i<4;i++){
                int newx= dx[i] + x;
                int newy = dy[i] + y;
                int newtime = time + 1;
                Pair currpair = new Pair(newx , newy ,newtime);
                if( newx>=0 && newx<n && newy>=0 && newy<m && grid[newx][newy]==1 && visited[newx][newy]==0){
                 queue.add(currpair);
                 visited[newx][newy]=1;
                }
              }

        }

        for(int i=0;i<n ;i++){
            for(int j=0;j<m ; j++){
                if(grid[i][j]==1)return -1;
            }
        }
        return ans;
    }
}
class Pair{
    int x;
    int y ;
    int time;
    Pair(int x , int y , int time){
        this.x = x;
        this.y = y;
        this.time=time;
    }
}
