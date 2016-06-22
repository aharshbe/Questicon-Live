package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AllianceSelectActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alliance_select);
    }


    public void clickingFramePandarin(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_pandaren);
        builder1.setTitle("Pandaren: The Gentle");
        builder1.setMessage("Couched in myth and legend, rarely seen and even more rarely understood, the enigmatic pandaren have long been a mystery to the other races of Azeroth. The noble history of the pandaren people stretches back thousands of years, well before the empires of man and before even the sundering of the world.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Pandarin",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(AllianceSelectActivity.this, PandarinAllianceActivity.class);
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

    public void clickingFrameWorgen(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_worgenreal);
        builder1.setTitle("Worgen: The Changed");
        builder1.setMessage("Behind the formidable Greymane Wall, a terrible curse has spread throughout the isolated human nation of Gilneas, transforming many of its stalwart citizens into nightmarish beasts known as worgen. The origins of this curse have been fiercely debated, but only recently has the startling truth come to light.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Worgen",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(AllianceSelectActivity.this, AllianceSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/worgen"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Worgen Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=IorM2yfiZCI"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameDraenei(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_draenei);
        builder1.setTitle("Draenei: The Holy");
        builder1.setMessage("Long before the fallen titan, Sargeras, unleashed his demonic Legion on Azeroth, he turned his baleful gaze upon the world of Argus and its highly intelligent inhabitants, the eredar. Believing that this magically gifted race would be a crucial component in his dark quest to undo all of creation, Sargeras contacted the eredar’s three leaders – Kil’jaeden, Archimonde, and Velen – and offered them knowledge and power in exchange for their loyalty.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Draenei",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(AllianceSelectActivity.this, AllianceSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/draenei"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Draenei Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=1JZpYvlWZiw"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameDwarf(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_dwarficon);
        builder1.setTitle("Dwarf: The Bold");
        builder1.setMessage("The bold and courageous dwarves are an ancient race descended from the earthen—beings of living stone created by the titans when the world was young. Due to a strange malady known as the curse of flesh, the dwarves’ earthen progenitors underwent a transformation that turned their rocky hides into soft skin. Ultimately, these creatures of flesh and blood dubbed themselves dwarves and carved out the mighty city of Ironforge in the snowy peaks of Khaz Modan.");

        builder1.setPositiveButton(
                "Select Dwarf",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(AllianceSelectActivity.this, AllianceSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/dwarf"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Dwarf Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=QorR7yB3g0E"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFramGnome(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_gnomeicon);
        builder1.setTitle("Gnome: The Clever");
        builder1.setMessage("The clever, spunky, and oftentimes eccentric gnomes present a unique paradox among the civilized races of Azeroth. Brilliant inventors with an irrepressibly cheerful disposition, this race has suffered treachery, displacement, and near-genocide. It is their remarkable optimism in the face of such calamity that symbolizes the truly unshakable spirit of the gnomes.");

        builder1.setPositiveButton(
                "Select Gnome",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(AllianceSelectActivity.this, AllianceSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/gnome"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Gnome Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=yB6SxWVdkpw"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameHuman(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_humanicon);
        builder1.setTitle("Human: The Resilient");
        builder1.setMessage("Recent discoveries have shown that humans are descended from the barbaric vrykul, half-giant warriors who live in Northrend. Early humans were primarily a scattered and tribal people for several millennia, until the rising strength of the troll empire forced their strategic unification. Thus the nation of Arathor was formed, along with its capital, the city-state of Strom.");

        builder1.setPositiveButton(
                "Select Human",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(AllianceSelectActivity.this, AllianceSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/human"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Human Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=J3wbr-kCWkY"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingFrameNightElf(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_nightelficon);
        builder1.setTitle("Night Elf: The Ancient");
        builder1.setMessage("The ancient and reclusive night elves have played a pivotal role in shaping Azeroth’s fate throughout its history. More than ten thousand years ago, their heroics during the War of the Ancients helped stave off the demonic Burning Legion’s first invasion. When the scattered remnants of the Legion on Azeroth rallied together with the vile satyrs centuries later, the night elves again rose to meet the threat. The ensuing War of the Satyr exacted a heavy toll from the night elves, but ultimately they vanquished the forces that had set out to wreak havoc on their world.");

        builder1.setPositiveButton(
                "Select Night Elf",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(AllianceSelectActivity.this, AllianceSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/night-elf"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Night Elf Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=t06fLvp3eMA"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


}
