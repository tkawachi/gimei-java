package net.moznion.gimei;

import net.moznion.gimei.address.Address;
import net.moznion.gimei.name.Female;
import net.moznion.gimei.name.Hanako;
import net.moznion.gimei.name.Male;
import net.moznion.gimei.name.Name;
import net.moznion.gimei.name.Taro;
import net.moznion.gimei.noun.Noun;

public class Gimei {
    public static Name generateName() {
        return new Name();
    }

    public static Male generateMale() {
        return new Male();
    }

    public static Female generateFemale() {
        return new Female();
    }

    public static Taro generateTaro() {
        return new Taro();
    }

    public static Hanako generateHanako() {
        return new Hanako();
    }

    public static Address generateAddress() {
        return new Address();
    }

    public static Noun generateNoun() {
        return new Noun();
    }
}
