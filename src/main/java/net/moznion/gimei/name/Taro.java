package net.moznion.gimei.name;

import net.moznion.gimei.NameUnit;
import net.moznion.gimei.NounDataSupplier;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Taro implements NameSuppliable {
    private final static NameUnit FIRST_NAME = new NameUnit(Arrays.asList("太郎", "たろう", "タロウ"));
    private final static Gender GENDER = Gender.MALE;
    private final NameUnit lastName;

    public Taro() {
        Random rand = new Random();

        List<NameUnit> nouns = NounDataSupplier.getNounData().getNouns();
        lastName = nouns.get(rand.nextInt(nouns.size()));
    }

    @Override
    public String kanji() {
        return lastName.kanji() + " " + FIRST_NAME.kanji();
    }

    @Override
    public String hiragana() {
        return lastName.hiragana() + " " + FIRST_NAME.hiragana();
    }

    @Override
    public String katakana() {
        return lastName.katakana() + " " + FIRST_NAME.katakana();
    }

    @Override
    public NameUnit last() {
        return lastName;
    }

    @Override
    public NameUnit first() {
        return FIRST_NAME;
    }

    @Override
    public boolean isMale() {
        return GENDER.isMale();
    }

    @Override
    public boolean isFemale() {
        return GENDER.isFemale();
    }
}
