interface PlayableCharacter {
    void performSpecialMove();
}
class Character {
    void attack() {
        System.out.println("Generic attack");
    }
    void defend() {
        System.out.println("Generic defend");
    }
}
class Warrior extends Character implements PlayableCharacter {
    void attack() {
        System.out.println("Warrior slashes sword!");
    }
    void defend() {
        System.out.println("Warrior blocks with shield!");
    }
    public void performSpecialMove() {
        System.out.println("Warrior Rage! Massive Damage.");
    }
}
class Archer extends Character implements PlayableCharacter {
    void attack() {
        System.out.println("Archer shoots arrow!");
    }
    void defend() {
        System.out.println("Archer dodges!");
    }
    public void performSpecialMove() {
        System.out.println("Arrow Storm! Multi-target hit.");
    }
}
class Mage extends Character implements PlayableCharacter {
    void attack() {
        System.out.println("Mage casts fireball!");
    }
    void defend() {
        System.out.println("Mage uses magic barrier!");
    }
    public void performSpecialMove() {
        System.out.println("Mana Burst! Area spell.");
    }
}
class GameCharacterSystem {
    public static void main(String[] args) {
        PlayableCharacter[] characters = {
            new Warrior(),
            new Archer(),
            new Mage()
        };
        for (PlayableCharacter pc : characters) {
            pc.performSpecialMove();
        }
    }
}
