package com.javasber.lesson1;

public class Person {

    private final boolean man;

    private final String name;

    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    private void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     *  If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     *  
     * @param person - new husband/wife for this person.
     */
    public boolean marry(Person person) {
        if (this.isMan() != person.isMan()) {
            this.divorce();
            person.divorce();
            this.setSpouse(person);
            person.setSpouse(this);
            return true;
        }
        return false;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been change 
     */
    public boolean divorce() {
        if (getSpouse() != null) {
            getSpouse().setSpouse(null);
            this.setSpouse(null);
            return true;
        }
        return false;
    }
}
