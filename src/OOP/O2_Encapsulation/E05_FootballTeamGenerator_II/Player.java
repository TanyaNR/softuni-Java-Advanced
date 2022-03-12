package OOP.O2_Encapsulation.E05_FootballTeamGenerator_II;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        if (!isValidStat(endurance)) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (!isValidStat(sprint)) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (!isValidStat(dribble)) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (!isValidStat(passing)) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (!isValidStat(shooting)) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    private boolean isValidStat(int skilLevel) {
        if (skilLevel < 0 || skilLevel > 100) {
            return false;
        }
        return true;
    }

    public double overallSkillLevel() {
        return ((double) this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5;
    }
}
