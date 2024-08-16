class Solution {
    public int[] solution(String[] wallpaper) {
        
        boolean[][] files = new boolean[wallpaper.length][wallpaper[0].length()];
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    files[i][j] = true;
                }else {
                    files[i][j] = false;
                }                        
            }            
        }
        
        int lux = wallpaper.length; 
        int luy = wallpaper[0].length();
        int rdx = 0; 
        int rdy = 0;
        
        for(int i =0; i < files.length; i++){
            for(int j = 0; j < files[i].length; j++){
             
                if(files[i][j]){
                    if(i < lux){ lux = i;}
                    if(j < luy){ luy = j;}
                    if(i > rdx){ rdx = i;}
                    if(j > rdy){ rdy = j;}
                }                
            }            
        }
    
        int[] answer = {lux, luy, rdx+1, rdy+1};
        return answer;
    }
}