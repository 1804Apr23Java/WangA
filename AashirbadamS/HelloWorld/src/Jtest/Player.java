package Jtest;

import java.util.Arrays;

public class Player {
        
    String playerName = "";
    String[] team = new String[3];

    public Player(String playerName) {
        super();
        this.playerName=playerName;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + Arrays.hashCode(team);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (!Arrays.equals(team, other.team))
			return false;
		return true;
	}

	public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public void testqueueisempty() {
    	
    	boolean t= false;
    	
    }
    public void addPlayertoQueue(String playerName) {
        for (int i = 0; i < 3; i++)
        {
            if(team[i] == null)
            {
                team[i] = playerName;
            }
            if(team[i] != null && i == 2)
            {
                for (i = 1; i < 3; i++)
                {
                    team[i-1] = team[i];
                }
                team[2] = playerName;
            }    

        }    
        
        
        

    }
        
        
}