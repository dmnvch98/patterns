package org.example.proxy;

public class WizardTowerProxy implements WizardTower {
    public static final int NUM_WIZARDS_ALLOWED = 3;
    private int wizardInTower;

    private final WizardTower wizardTower;

    public WizardTowerProxy(WizardTower wizardTower) {
        this.wizardTower = wizardTower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (wizardInTower < NUM_WIZARDS_ALLOWED) {
            wizardTower.enter(wizard);
            wizardInTower++;
        } else {
            System.out.println(wizard + " is not allowed to enter the tower");
        }
    }
}
