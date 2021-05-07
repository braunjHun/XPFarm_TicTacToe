public class Step {
    private Player player;
    private int xCo;
    private int yCo;
    public Step(Player player, int xCo, int yCo) {
        this.player = player;
        this.xCo = xCo;
        this.yCo = yCo;
    }
    public Player getPlayer() {
        return player;
    }
    public int getxCo() {
        return xCo;
    }
    public int getyCo() {
        return yCo;
    }

    
}
