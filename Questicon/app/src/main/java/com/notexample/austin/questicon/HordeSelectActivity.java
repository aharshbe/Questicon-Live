package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HordeSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horde_select);
    }

    public void clickingFramePandarinHorde(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_pandaren);
        builder1.setTitle("Pandaren: The Gentle");
        builder1.setMessage("Couched in myth and legend, rarely seen and even more rarely understood, the enigmatic pandaren have long been a mystery to the other races of Azeroth. The noble history of the pandaren people stretches back thousands of years, well before the empires of man and before even the sundering of the world.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Pandarin",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HordeSelectActivity.this, HordeSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/pandaren"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Pandarin Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=UQh94o_Ph_I"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameGoblin(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_goblinicon);
        builder1.setTitle("Goblin: The Reforged");
        builder1.setMessage("Originally the slaves of jungle trolls on the Isle of Kezan, goblins were forced to mine kaja’mite ore out of the volcanic bowels of Mount Kajaro. The trolls used this potent mineral for their voodoo rituals, but it had an unexpected effect on the slaves who were in constant contact with it: kaja’mite generated a startling new cunning and intelligence in the goblin race.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Goblin",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HordeSelectActivity.this, HordeSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/goblin"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Goblin Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=_QbRqr3S8G8"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameBloodElf(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_bloodelficon);
        builder1.setTitle("Blood Elf: The Magical");
        builder1.setMessage("For nearly 7,000 years, high elven society centered on the sacred Sunwell, a magical fount that was created using a vial of pure arcane energy from the first Well of Eternity. Nourished and strengthened by the Sunwell’s potent energies, the high elves’ enchanted kingdom of Quel’Thalas prospered within the verdant forests north of Lordaeron.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Blood Elf",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HordeSelectActivity.this, BloodElfAcitivty.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/blood-elf"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Blood Elf Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=30wOJoD43UU"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameOrc(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_orcicon);
        builder1.setTitle("Orc: The Alien");
        builder1.setMessage("Unlike the other races of the Horde, orcs are not native to Azeroth. Initially, they lived as shamanic clans on the lush world of Draenor. They abandoned their peaceful culture when Kil’jaeden, a demon lord of the Burning Legion, corrupted the orcs and used them in his vengeful plot against the draenei, who were exiles from Kil’jaeden’s homeworld.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Orc",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HordeSelectActivity.this, OrcAcitivty.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/orc"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Orc Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=eNR_mnnzgzo"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameTauren(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_taurencrest);
        builder1.setTitle("Turen: The Tranquil");
        builder1.setMessage("The peaceful tauren—known in their own tongue as the shu’halo—have long dwelled in Kalimdor, striving to preserve the balance of nature at the behest of their goddess, the Earth Mother. Until recently, the tauren lived as nomads scattered throughout the Barrens, hunting the great kodo beasts native to the arid region.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Tauren",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HordeSelectActivity.this, TaurenAcitivty.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/tauren"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Tauren Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=JftJjAvUWcE"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameTroll(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_trollcresticon);
        builder1.setTitle("Troll: The Islanders");
        builder1.setMessage("The savage trolls of Azeroth are infamous for their cruelty, dark mysticism, and seething hatred for all other races. Yet one exception among the trolls is the Darkspear tribe and its cunning leader, Vol’jin. Plagued by a history of subservience and exile, this proud tribe was on the brink of extinction when Warchief Thrall and his mighty Horde forces were driven to the trolls’ remote island home in the South Seas during a violent storm.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Troll",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HordeSelectActivity.this, TrollAcitivty.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/troll"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Troll Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=35J2dHUDrvM"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameUndead(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_undeadicon);
        builder1.setTitle("Undead: The Forsaken");
        builder1.setMessage("Death offered no escape for the scores of humans killed during the Lich King’s campaign to scour the living from Lordaeron. Instead, the kingdom’s fallen were risen into undeath as Scourge minions and forced to wage an unholy war against everything… and everyone… that they once held dear.");
        builder1.setCancelable(true);


        builder1.setPositiveButton(
                "Select Undead",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HordeSelectActivity.this, UndeadActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/undead"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Undead Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=F9NtgU5Y7NE"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
