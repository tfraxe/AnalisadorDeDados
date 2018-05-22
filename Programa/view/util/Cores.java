package view.util;

import java.awt.Color;

public class Cores
{
    private Color BRANCO_FORTE;
    private Color BRANCO_MEDIO;
    private Color BRANCO_FRACO;

    public Cores()
    {
        BRANCO_FORTE = new Color(255, 255, 255);
        BRANCO_MEDIO = new Color(250, 250, 250);
        BRANCO_FRACO = new Color(245, 245, 245);
    }

    public Color BRANCO_FORTE()
    {
        return BRANCO_FORTE;
    }

    public Color BRANCO_MEDIO()
    {
        return BRANCO_MEDIO;
    }

    public Color BRANCO_FRACO()
    {
        return BRANCO_FRACO;
    }
} 