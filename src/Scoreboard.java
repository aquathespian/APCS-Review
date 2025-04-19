public class Scoreboard {
    //Initializers for both teams
    private String team1;
    private String team2;
    private int team1Score;
    private int team2Score;
    private String activeTeam;

    public Scoreboard(String team1, String team2) {
        activeTeam = team1;
        this.team1 = team1;
        this.team2 = team2;
        team1Score = 0;
        team2Score = 0;
    }

    public void recordPlay(int pointsScored) {
        if (pointsScored > 0) {
            if (activeTeam.equals(team1)) team1Score += pointsScored;
            else team2Score += pointsScored;
        }
        else if (pointsScored == 0) {
            if (activeTeam.equals(team1)) activeTeam = team2;
            else activeTeam = team1;
        }
    }

    public String getScore() {
        return team1Score + "-" + team2Score + "-" + activeTeam;
    }

    //main method for testing
    public static void main(String[] args) {
        Scoreboard game = new Scoreboard("Red", "Blue");
        System.out.println(game.getScore());
        game.recordPlay(1);
        System.out.println(game.getScore());
        game.recordPlay(0);
        System.out.println(game.getScore());
        System.out.println(game.getScore());
        game.recordPlay(3);
        System.out.println(game.getScore());
        game.recordPlay(1);
        game.recordPlay(0);
        System.out.println(game.getScore());
        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        System.out.println(game.getScore());
        Scoreboard match = new Scoreboard("Lions", "Tigers");
        System.out.println(match.getScore());
        System.out.println(game.getScore());
    }
}