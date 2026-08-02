package com.conecta4.games;

import java.util.LinkedList;
import java.util.List;

import com.conecta4.terminations.FourColorsOrFourFormsTerminationStrategy;
import com.conecta4.terminations.Termination;
import com.conecta4.tokens.BlueDisc;
import com.conecta4.tokens.BlueSquare;
import com.conecta4.tokens.BlueTriangule;
import com.conecta4.tokens.RedDisc;
import com.conecta4.tokens.RedSquare;
import com.conecta4.tokens.RedTriangule;
import com.conecta4.tokens.Token;

public class FourColorsOrFourFormsGame extends GameFactory{
    public FourColorsOrFourFormsGame(){
        super.p1Options = new LinkedList<>();
        p1Options.addAll(List.of("BD", "BT", "BS"));
        super.p2Options = new LinkedList<>();
        p2Options.addAll(List.of("RD", "RT", "RS"));
    }

    @Override
    public Termination createTermination(int n) {
        return new Termination(new FourColorsOrFourFormsTerminationStrategy());
    }

    @Override
    public Token createToken(String representation) {
        if (representation.equals("RD")) return new Token(new RedDisc());
        else if (representation.equals("RT")) return new Token(new RedTriangule());
        else if (representation.equals("RS")) return new Token(new RedSquare());
        else if (representation.equals("BD")) return new Token(new BlueDisc());
        else if (representation.equals("BT")) return new Token(new BlueTriangule());
        else if (representation.equals("BS")) return new Token(new BlueSquare());
        else throw new IllegalArgumentException();
    }
}
