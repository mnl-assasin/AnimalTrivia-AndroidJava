package com.pwucdcec.animaltrivia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mykelneds on 06/02/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DB_ANIMALTRIVIA";
    public static final int DB_VERSION = 14;
    public static final String TABLE_NAME = "TBL_ANIMALS";

    private static DatabaseHelper mInstance = null;

    private DatabaseHelper(Context mContext) {
        super(mContext, DB_NAME, null, DB_VERSION);
    }

    public static DatabaseHelper getInstance(Context mContext) {
        if (mInstance == null) {
            mInstance = new DatabaseHelper(mContext);
        }

        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS TBL_ANIMALS (id integer, category integer, name varchar, drawable integer, isSolved integer, scientificName varchar, description varchar)");
//        db.execSQL("CREATE TABLE IF NOT EXISTS TBL_DESCRIPTION (id varchar, name varchar, scientificName varchar, description varchar)");
        populateData(db);
    }

    private void populateData(SQLiteDatabase db) {

//        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (0, " + Const.CAT_AMPHIBIANS + ",'', " + R.drawable.amphibians_ + ", 0, " +
//                "'', '')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (1, " + Const.CAT_AMPHIBIANS + ",'Platymantis', " + R.drawable.amphibians_platymantis + ", 0, " +
                "'Platymantis', 'Platymantis is a genus of frogs in the family Ceratobatrachidae. They are commonly known as wrinkled ground frogs, ground frogs, and forest frogs.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (2, " + Const.CAT_AMPHIBIANS + ",'Limnonectes', " + R.drawable.amphibians_limnonectes + ", 0, " +
                "'Limnonectes', 'Limnonectes is a genus of fork-tongued frogs of about 64 known species, but new ones are still being described occasionally.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (3, " + Const.CAT_AMPHIBIANS + ",'Kaloula', " + R.drawable.amphibians_kaloula + ", 0, " +
                "'Kaloula', 'Kaloula is a genus of microhylid frogs found in South Asia, Southeast Asia and East Asia. They are sometimes known as the Asian narrowmouth toads.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (4, " + Const.CAT_AMPHIBIANS +
                ",'Common puddle frog', " + R.drawable.amphibians_puddlefrog + ", 0, " + "'Occidozyga laevis', 'The common puddle frog, puddle frog, or yellow bellied puddle frog is a species of frog in the Dicroglossidae family.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (5, " + Const.CAT_AMPHIBIANS +
                ",'Island forest frog', " + R.drawable.amphibians_islandforestfrog + ", 0, " + "'Platymantis insulata', 'The island forest frog is a species of frog in the family Ceratobatrachidae. It is endemic to the Philippines. It is found only on South Gigante Island just northeast of Panay, where it inhabits limestone karst habitats.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (6, " + Const.CAT_AMPHIBIANS +
                ",'Giant Visayan frog', " + R.drawable.amphibians_giantvisayanfrog + ", 0, " + "'Limnonectes visayanus', 'The Giant Visayan frog is a species of frog in the Dicroglossidae family. It is endemic to the Philippines, and is known from Masbate, Cebu, Negros, Guimaras, Panay, and Siquijor islands.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (7, " + Const.CAT_AMPHIBIANS +
                ",'Common tree frog', " + R.drawable.amphibians_treefrog + ", 0, " + "'Polypedates leucomystax', 'Polypedates leucomystax is a species in the shrub frog family Rhacophoridae. It is known under numerous common names, including common tree frog, four-lined tree frog, golden tree frog or striped tree frog.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (8, " + Const.CAT_AMPHIBIANS +
                ",'Panay forest frog', " + R.drawable.amphibians_panayforestfrog + ", 0, " + "'Platymantis panayensis', 'The Panay forest frog is a species of frog in the family Ceratobatrachidae. It is endemic to western Panay, Philippines. Its natural habitats are subtropical or tropical moist lowland forest and subtropical or tropical moist montane forest.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (9, " + Const.CAT_AMPHIBIANS +
                ",'Palawan toadlet', " + R.drawable.amphibians_palawantoadlet + ", 0, " + "'Pelophryne albotaeniata', 'The Palawan toadlet or white-striped flathead toad is a species of toad in the family Bufonidae. It is endemic to Palawan, the Philippines.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (10, " + Const.CAT_AMPHIBIANS +
                ",'Luzon narrow-mouthed frog', " + R.drawable.amphibians_narrowmouthedfrog + ", 0, " + "'Kaloula rigida', 'The Luzon narrow-mouthed frog is a species of frog in the family Microhylidae. It is endemic to the Central Cordilleras and Sierra Madres of northern Luzon, Philippines.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (11, " + Const.CAT_AMPHIBIANS +
                ",'Pygmy forest frog', " + R.drawable.amphibians_pygmyforestfrog + ", 0, " + "'Platymantis pygmaea', 'The pygmy forest frog is a species of frog in the family Ceratobatrachidae. It is endemic to the Philippines. It occurs in the Central Cordilleras and Sierra Madres of northern Luzon, and possibly also on Sibuyan Island.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (12, " + Const.CAT_AMPHIBIANS +
                ",'Luzon fanged frog', " + R.drawable.amphibians_fangedfrog + ", 0, " + "'Limnonectes macrocephalus', 'The Luzon fanged frog is a species of frog in the family Dicroglossidae. It is endemic to the Philippines.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (13, " + Const.CAT_AMPHIBIANS +
                ",'Rabors forest frog', " + R.drawable.amphibians_raborforestfrog + ", 0, " + "'Platymantis rabori', 'The Rabors forest frog is a species of frog in the family Ceratobatrachidae. It is endemic to the southern Philippines, where it occurs in the rainforests of Bohol, Leyte, and Mindanao islands.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (14, " + Const.CAT_AMPHIBIANS +
                ",'Pelophryne', " + R.drawable.amphibians_pelophryne + ", 0, " + "'Pelophryne', 'Pelophryne is a genus of true toads endemic to Philippines, Borneo, Malaya, Singapore and Hainan Island, China.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (15, " + Const.CAT_AMPHIBIANS +
                ",'Alcalus mariae', " + R.drawable.amphibians_alcalusmariae + ", 0, " + "'Ingerana mariae', 'Alcalus mariae, common name Marys frog or Palawan eastern frog is a species of frog in the Ceratobatrachidae family.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (16, " + Const.CAT_AMPHIBIANS +
                ",'Rhacophoridae', " + R.drawable.amphibians_rhacophoridae + ", 0, " + "'Rhacophoridae', 'The Rhacophoridae are a family of frog species, which occur in tropical sub-Saharan Africa, South India and Sri Lanka, Japan; northeastern India to eastern China south through the Philippines and Greater Sundas, and Sulawesi.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (17, " + Const.CAT_AMPHIBIANS +
                ",'Fejervarya moodiei', " + R.drawable.amphibians_fejervaryamoodiei + ", 0, " + "'Fejervarya moodiei', 'Fejervarya moodiei is a species of frog in the Dicroglossidae family. It has in the past been often mixed with Fejervarya cancrivora; its distribution is not well known but includes the Philippines, Thailand, Hainan Island, and India.7*893')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (18, " + Const.CAT_AMPHIBIANS +
                ",'Pelophryne lighti', " + R.drawable.amphibians_pelophrynelighti + ", 0, " + "'Pelophryne lighti', 'Pelophryne lighti is a species of toad in the family Bufonidae.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (19, " + Const.CAT_AMPHIBIANS +
                ",'Platymantis guentheri', " + R.drawable.amphibians_platymantisguentheri + ", 0, " + "'Platymantis guentheri', 'Platymantis guentheri is a species of frog in the Ceratobatrachidae family. It is endemic to the Philippines, where it occurs in the rainforests of Leyte, Biliran, Maripipi, Bohol, Panglao, Dinagat, and Mindanao islands.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (20, " + Const.CAT_AMPHIBIANS +
                ",'Banahao forest frog', " + R.drawable.amphibians_banahaoforestfrog + ", 0, " + "'Platymantis banahao', 'The Banahao forest frog is a species of frog in the family Ceratobatrachidae. It is endemic to Luzon, Philippines, where it is only known from Mount Banahaw.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (1, " + Const.CAT_BIRDS +
                ",'Grebe', " + R.drawable.birds_grebe + ", 0, " + "'Tachybaptus ruficollis', " +
                "'<b>Habitat:</b> Freshwater ponds & marshlands.<br><b>Birdwatch note:</b> Smallest duck like bird in the Philippines. Small size, short neck and yellow spot before eye. Dives to ctach food or when disturbed. Seen regularly in Candaba.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (2, " + Const.CAT_BIRDS +
                ",'Great Cormorant', " + R.drawable.birds_gcormorant + ", 0, " + "'Phalacrocorax carbo', " +
                "'<b>Habitat:</b> Found along the coasts.<br><b>Birdwatch note:</b> Rare migrant. Perches on rocks or in trees near coasta drying outstretched wings. Forages by diving underwater to catch fish. Note large hooked bill, yellow gular area and white throat in all plumages.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (3, " + Const.CAT_BIRDS +
                ",'Red-footed Booby', " + R.drawable.birds_redfootedbooby + ", 0, " + "'Sula Sula', " +
                "'<b>Habitat:</b> Forages in open ocean, nests in trees on remote islands in Sulu Sea<br><b>Birdwatch note:</b> Uncommon.  Dives into water head first catching fish with its bill.  Will follow ships and often lands on them.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (4, " + Const.CAT_BIRDS +
                ",'Grey Heron', " + R.drawable.birds_greyheron + ", 0, " + "'Ardea cinerea', " +
                "'<b>Habitat:</b> Freshwater marshes to tidal flats<br><b>Birdwatch note:</b> Uncommon migrant, sharp contrast between dark flight feathers and grey coverts during flight.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (5, " + Const.CAT_BIRDS +
                ",'Purple Heron', " + R.drawable.birds_purpleheron + ", 0, " + "'Ardea purpurea', " +
                "'<b>Habitat:</b> All types of wetlands from coastal marshes to rice fields<br><b>Birdwatch note:</b> Fairly common resident. Large rufous, black and grey heron. Nests in colonies in isolated patches of trees.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (6, " + Const.CAT_BIRDS +
                ",'Great Egret', " + R.drawable.birds_greategret + ", 0, " + "'Egretta alba', " +
                "'<b>Habitat:</b> Coastal marshes to ricefields.<br><b>Birdwatch note:</b> Uncommon migrant, often joining other egrets. Wintering birds have yellow bill and all black legs and feet.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (7, " + Const.CAT_BIRDS +
                ",'Chinese Egret', " + R.drawable.birds_chineseegret + ", 0, " + "'Egretta eulophotes', " +
                "'<b>Habitat:</b> Shallow tidal flats and ricefields.<br><b>Birdwatch note:</b> Endangered species. Rare migrant. Yellowish bill, greenish facial skin and greenish legs.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (8, " + Const.CAT_BIRDS +
                ",'Little Egret', " + R.drawable.birds_littleegret + ", 0, " + "'Egretta Garzetta', " +
                "'<b>Habitat:</b> Coastal marsh, tidal flats and ricefields<br><b>Birdwatch note:</b> Common migrant. Black bill, black legs and yellow feet.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (9, " + Const.CAT_BIRDS +
                ",'Straited Heron', " + R.drawable.birds_striatedheron + ", 0, " + "'Butorides striatus', " +
                "'<b>Habitat:</b> Tidal flats, mangroves, fish ponds and streams<br><b>Birdwatch note:</b> Common, with resident and migrant population. Perches motionless, shy and solitary. Commonly seen in Tambo mudflats and Coastal Road lagoon. Also recorded at the Ateneo campus in QC.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (10, " + Const.CAT_BIRDS +
                ",'Cattle Egret', " + R.drawable.birds_cattleegret + ", 0, " + "'Bubulcus ibis', " +
                "'<b>Habitat:</b> Common in pastures, ricefields and marshes.<br><b>Birdwatch note:</b> Short yellows bills with all black legs. Breeding birds have orange buff head, breast and back.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (11, " + Const.CAT_BIRDS +
                ",'Yellow Bittern', " + R.drawable.birds_ybittern3 + ", 0, " + "'Ixobrychus sinensis', " +
                "'<b>Habitat:</b> Common in freshwater wetlands<br><b>Birdwatch note:</b> Often seen flying low, identifiable by the black flight feathers.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (12, " + Const.CAT_BIRDS +
                ",'Black Bittern', " + R.drawable.birds_blackbittern + ", 0, " + "'Dupetor flavicollis', " +
                "'<b>Habitat:</b> Wetlands from ricefields to mangroves, prefers reed beds often mixed with shrubs<br><b>Birdwatch note:</b> Uncommon resident, medium-sized with long, slender bill. Secretive and solitary. Has slow, steady flight. Roosts in trees over water or even far from it.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (13, " + Const.CAT_BIRDS +
                ",'Great Bittern', " + R.drawable.birds_greatbittern + ", 0, " + "'Botaurus stellaris', " +
                "'<b>Habitat:</b> Found in freshwater reed beds and marshes<br><b>Birdwatch note:</b> Rare migrant, less than 10 sightings in the country. Usually seen only when flushed or flying low over wetlands.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (14, " + Const.CAT_BIRDS +
                ",'Osprey', " + R.drawable.birds_osprey + ", 0, " + "'Pandion haliaetus', " +
                "'<b>Habitat:</b> Associated with water,both along the coast and inland.<br>" +
                "<b>Birdwatch note:</b> Uncommon migrant. Feeds exclusively on fish caught by diving feet first into the water.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (15, " + Const.CAT_BIRDS +
                ",'Oriental Honey - Buzzard', " + R.drawable.birds_orientalhoneybuzzard + ", 0, " + "'Pernis ptilorhynchus', " +
                "'<b>Habitat:</b> Forests from lowlands to middle elevation.<br>" +
                "<b>Birdwatch note:</b> Migrant and resident populations. Characterized by long ìturkey-likeî neck. Eats insects, particularly bees which they obtain from nests in tree hollows or suspended in trees.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (16, " + Const.CAT_BIRDS +
                ",'Brahminy Kite', " + R.drawable.birds_brahminy + ", 0, " + "'Haliastur indus', " +
                "'<b>Habitat:</b> Common in areas near water but also in mountains up to 1500m.<br>" +
                "<b>Birdwatch note:</b> One individual recorded at the American Cemetery from October - November 2003.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (17, " + Const.CAT_BIRDS +
                ",'White - bellied Sea - eagle', " + R.drawable.birds_wbseaeagle + ", 0, " + "'Haliaeetus leucogaster', " +
                "'<b>Habitat:</b> Coastal areas specially remote offshore islands. Also large lakes and rivers.<br>" +
                "<b>Birdwatch note:</b> White underparts in contrast with dark flight feathers. During flight, wings held forward slightly bent at wrist. Not common but has been recorded in the coastal areas of Mt. Palay-Palay, Cavite.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (18, " + Const.CAT_BIRDS +
                ",'Eastern Marsh - Harrier', " + R.drawable.birds_eastmharrier + ", 0, " + "'Circus spilonotus', " +
                "'<b>Habitat:</b> Wetlands and grasslands<br>" +
                "<b>Birdwatch note:</b> Migrant. Flies low over ground with wings held in slight V.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (19, " + Const.CAT_BIRDS +
                ",'Chinese Goshawk', " + R.drawable.birds_cgoshawk + ", 0, " + "'Accipiter soloensis', " +
                "'<b>Habitat:</b> Fairly common in forest and forest edge.<br>" +
                "<b>Birdwatch note:</b> Hunts from perches flying out to catch insects and other prey from ground or air. Migrates in huge flocks. Told from other accipiters by black wing tips in adults.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (20, " + Const.CAT_BIRDS +
                ",'Crested Goshawk', " + R.drawable.birds_crestedgoshawk + ", 0, " + "'Accipiter trivigatus', " +
                "'<b>Habitat:</b> Forest and forest edge<br>" +
                "<b>Birdwatch note:</b> Common resident. Prefers to hunt from low perches. Distinctive short crest and barred flanks.')");


//        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (0, " + Const.CAT_FISH +
//                ",'', " + R.drawable.fish_ + ", 0, " + "'', '')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (1, " + Const.CAT_FISH +
                ",'Alumahan', " + R.drawable.fish_alumahan + ", 0, " + "'Long-Jawed Mackarel', 'These species are commonly found in tropical and salty waters in the Indian and Western Pacific ocean, which vary in sizes as well.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (2, " + Const.CAT_FISH +
                ",'Salay-salay', " + R.drawable.fish_salaysalay + ", 0, " + "'Yellow tail Scad', 'These species are small and somewhat easy to catch although their meat is slightly coarse. They belong in the scad family, and are known for the distinct yellow details in their bodies and tails')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (3, " + Const.CAT_FISH +
                ",'Galunggong', " + R.drawable.fish_galunggong + ", 0, " + "'Mackerel Scad', 'This fish is extremely popular in Philippine markets, especially with the masses as they are relatively inexpensive and remarkably tasty. They are found in salt waters especially in Northeastern Palawan and in Navotas - dubbed as the country is fishing capital.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (4, " + Const.CAT_FISH +
                ",'Salmon', " + R.drawable.fish_salmon + ", 0, " + "'Threadfin Salmon', 'This kind of fish is known for their body designs. They are common in saltwater and popular in the Philippine market because of their flavorful meat.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (5, " + Const.CAT_FISH +
                ",'Bangus', " + R.drawable.fish_bangus + ", 0, " + "'Milk fish', 'Many people consider this fish as the Philippinesí national fish. Having a silvery scales and milky white bottom are what makes it distinct and attractive.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (6, " + Const.CAT_FISH +
                ",'Dalagang Bukid', " + R.drawable.fish_dalagangbukid + ", 0, " + "'Goldband/Yellow tail Fusilie', 'This fish got its name because of its unique red color. The color red is often used in describing Filipina farm girls wearing a wrap-around skirt in the province which is usually colored in red.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (7, " + Const.CAT_FISH +
                ",'Dilis', " + R.drawable.fish_dilis + ", 0, " + "'Anchovy', 'This type of fish is extremely popular in the Philippine market especially with the masses for it is affordable and are very small. They are common in shallow reefs in almost any reef in the country itself. They are filter-feeders that open their mouths as they swim.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (8, " + Const.CAT_FISH +
                ",'Loro', " + R.drawable.fish_loro + ", 0, " + "'Parrot Fish', 'Filipino fishermen usually have difficulty catching this fish because of their unique diet and coral-crunching teeth. What makes this fish special is its colorful scales and parrot-like teeth, thus earning their name for it.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (9, " + Const.CAT_FISH +
                ",'Tambakol', " + R.drawable.fish_tambakol + ", 0, " + "'Skipjack/Yellowfin tuna', 'This fish is commonly found in the depths of waters since they are known to dive deep; you can sometimes fish them along the surface. They mainly feed on schools and squid but it is to consider that their diet also differ from time to time.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (10, " + Const.CAT_FISH +
                ",'Danggit', " + R.drawable.fish_danggit + ", 0, " + "'Rabbit Fish', 'This is a Filipino favorite fish often eaten by Filipino families during breakfast. They are found in many saltwater in the country and are extremely popular in the Philippine market because of their expensive value, and also because they are easy to prepare and cook.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (11, " + Const.CAT_FISH +
                ",'Kanduli', " + R.drawable.fish_kanduli + ", 0, " + "'Veined catfish', 'This type of fish belong to the catfish or hito family. They are found in tropical marine waters, especially in salty environments. They are found in the Philippine market either alive or dead, and often mistaken for a catfish or hito.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (12, " + Const.CAT_FISH +
                ",'Maya-maya', " + R.drawable.fish_mayamaya + ", 0, " + "'Ruby snapper', 'This type of fish is popular in Philippine markets due to their delicate and flavorful white meat. They usually vary in size that can either be small or big. They are known for their vivid and distinct red color and are commonly found in salty environments and shallow reefs.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (13, " + Const.CAT_FISH +
                ",'Sapsap', " + R.drawable.fish_sapsap + ", 0, " + "'Ponyfish/Slipmouth', 'This type of fish is usually characterized by their slimy bodies, small scales, and a widely extending mouth. They only grow under six (6) inches in length. Because of its abundant population in its natural habitat- the shallow coastal waters. This feed is also usually used for various food cuisines especially in the country.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (14, " + Const.CAT_FISH +
                ",'Tulingan', " + R.drawable.fish_tulingan + ", 0, " + "'Mackarel Tuna', 'With its vertical stripes at the back, deeply forked tail, and a small velvety touch of scale, this fish is usually found offshores of both temperate and tropical seas commonly swimming with a school across the deep ocean.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (15, " + Const.CAT_FISH +
                ",'Hiwas', " + R.drawable.fish_hiwas + ", 0, " + "'Splendid Ponyfish', 'This type of fish is usually found in muddy, salty waters and often in deep waters. They are often mistaken for the sap-sap fish due to their similar features- flat body, big head, and nuance difference in their color.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (16, " + Const.CAT_FISH +
                ",'Lapu-lapu', " + R.drawable.fish_lapulapu + ", 0, " + "'Coral trout/Red grouper', 'Groupers are high-valued type of fish because of their white, flaky flesh which are usually distributed in markets either dead or alive. They are commonly found in saltwaters and are hard to raise because of their carnivorous nature, while being active during the night.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (17, " + Const.CAT_FISH +
                ",'Salmonete', " + R.drawable.fish_salmonte + ", 0, " + "'Red Mullet', 'This type of fish have  distinct bright colored scales and is often characterized by a pair of chin barbels. They are sometimes distinguished having a double beard on its lower lip. They also possess a deep, elongated body; forked tail, and dorsal fins that are widely separated.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (18, " + Const.CAT_FISH +
                ",'Tawilis', " + R.drawable.fish_tawilis + ", 0, " + "'Sardinella tawilis', 'This type of fish are migratory fishes that can only be found in the Philippines, in lake Taal, which is the 3rd largest lake in the country. This specie is the only fish belonging to their genius that live entirely in fresh waters.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (19, " + Const.CAT_FISH +
                ",'Tilapia', " + R.drawable.fish_tilapia + ", 0, " + "'Mayan Cichlids', 'this fish is obviously one of the most abundant kind of fish that can be found in the Philippine archipelago. The term ìtilapiaî however, covers nearly hundreds of different species in general.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (20, " + Const.CAT_FISH +
                ",'Catfish', " + R.drawable.fish_catfish + ", 0, " + "'Clarias batrachus', 'The walking catfish is a species of freshwater airbreathing catfish native to Southeast Asia. It is named for its ability to \"walk\" and wiggle across dry land, to find food or suitable environments.')");

//        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (0, " + Const.CAT_MAMMALS +
//                ",'', " + R.drawable.mammals_ + ", 0, " + "'', '')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (1, " + Const.CAT_MAMMALS +
                ",'Philippine flying lemur', " + R.drawable.mammals_flyinglemur + ", 0, " + "'Cynocephalus volans', 'also known as Philippine flying lemur or Colugo(Eng., Kagwang (Vis.) and Kabal (Bagobo) of the family Cynocephalidae is approximately two (2) genera. The name flying lemur is misleading, as they are not lemurs and they cannot truly fly instead they have the habit of jumping and gliding from one tree to another hence they are called glider.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (2, " + Const.CAT_MAMMALS +
                ",'Palawan fruit bat', " + R.drawable.mammals_palawan_fruit_bat + ", 0, " + "'Acerodon leucotis', 'The Palawan fruit bat (Acerodon leucotis), also known as the Palawan flying fox, is a species of megabat found in forests')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (3, " + Const.CAT_MAMMALS +
                ",'Visayan warty pig', " + R.drawable.mammals_wartypig + ", 0, " + "'Sus cebifrons', 'The Visayan warty pig is a critically endangered species in the pig genus. It is known by many names in the region with most translating into wild pig: baboy damo, baboy ihalas, baboy talonon, bakatin, baboy sulop, manggalisak banban, and biggal.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (4, " + Const.CAT_MAMMALS +
                ",'False Killer Whale', " + R.drawable.mammals_fkwhale + ", 0, " + "'Pseudorca crassidens', 'The false killer whale is the fourth-largest dolphin, a member of the oceanic dolphins. It lives in temperate and tropical waters throughout the world.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (5, " + Const.CAT_MAMMALS +
                ",'Pantropical spotted dolphin', " + R.drawable.mammals_pantropical_spotted_dolphin + ", 0, " + "'Stenella attenuata', 'The pantropical spotted dolphin is a species of dolphin found in all the worlds temperate and tropical oceans. The species was beginning to come under threat due to the killing of millions of individuals in tuna purse seines.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (6, " + Const.CAT_MAMMALS +
                ",'Oriental small-clawed otter', " + R.drawable.mammals_smallclawedotter + ", 0, " + "'Aonyx cinerea', 'The Asian small-clawed otter, also known as the oriental small-clawed otter or simply small-clawed otter, is a semiaquatic mammal native to South and Southeast Asia.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (7, " + Const.CAT_MAMMALS +
                ",'Palawan stink badger', " + R.drawable.mammals_palawan_stink_badger + ", 0, " + "'Mydaus marchei', 'The Palawan stink badger, or pantot, is a carnivoran of the western Philippines named for its resemblance to badgers, its powerful smell, and the largest island to which it is native, Palawan.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (8, " + Const.CAT_MAMMALS +
                ",'Asian palm civet', " + R.drawable.mammals_palm_civet + ", 0, " + "'Paradoxurus hermaphroditus', 'The Asian palm civet is a small viverrid native to South and Southeast Asia. Since 2008, it is IUCN Red Listed as Least Concern as it is tolerant of a broad range of habitats.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (9, " + Const.CAT_MAMMALS +
                ",'Mindanao flying squirrel', " + R.drawable.mammals_flyingsquirrel + ", 0, " + "'Petinomys mindanensis', 'The Mindanao flying squirrel is a common species of squirrel that is endemic to the Philippines.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (10, " + Const.CAT_MAMMALS +
                ",'Dugong', " + R.drawable.mammals_seacow + ", 0, " + "'Dugong dugon', 'The dugong is a medium-sized marine mammal. It is one of four living species of the order Sirenia, which also includes three species of manatees.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (11, " + Const.CAT_MAMMALS +
                ",'Tamaraw', " + R.drawable.mammals_tamaraw + ", 0, " + "'Bubalus mindorensis', 'The tamaraw or Mindoro dwarf buffalo is a small hoofed mammal belonging to the family Bovidae. It is endemic to the island of Mindoro in the Philippines, and is the only endemic Philippine bovine.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (12, " + Const.CAT_MAMMALS +
                ",'Philippine tarsier', " + R.drawable.mammals_philippinetarsier + ", 0, " + "'Carlito syrichta', 'The Philippine tarsier, known locally as mawmag in Cebuano/Visayans and mamag in Luzon, is a species of tarsier endemic to the Philippines.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (13, " + Const.CAT_MAMMALS +
                ",'Calamian deer', " + R.drawable.mammals_calamiandeer + ", 0, " + "'Axis calamianensis', 'The Calamian deer, also known as Calamian hog deer, is an endangered species of deer found only in the Calamian Islands of Palawan province of the Philippines.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (14, " + Const.CAT_MAMMALS +
                ",'Binturong', " + R.drawable.mammals_binturong + ", 0, " + "'Arctictis binturong', 'The binturong, also known as bearcat, is a viverrid native to South and Southeast Asia.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (15, " + Const.CAT_MAMMALS +
                ",'Carabao', " + R.drawable.mammals_carabao + ", 0, " + "'Bubalus bubalis carabanesis', 'The carabao is a swamp-type domestic water buffalo native to the Philippines. Water buffaloes were probably introduced to the Philippines by Malay immigrants around 300 to 200 AC.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (16, " + Const.CAT_MAMMALS +
                ",'Large Flying fox', " + R.drawable.mammals_flyingfox + ", 0, " + "'Pteropus vampyrus', 'The large flying fox, also known as the greater flying fox, Malayan flying fox, Malaysian flying fox, large fruit bat, kalang or kalong, is a southeast Asian species of megabat in the family Pteropodidae.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (17, " + Const.CAT_MAMMALS +
                ",'Murids', " + R.drawable.mammals_murids + ", 0, " + "'Muridae', 'The Muridae, or murids, are the largest family of rodents and of mammals, containing over 700 species found naturally throughout Eurasia, Africa, and Australia. The name Muridae comes from the Latin mus, meaning \"mouse\".')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (18, " + Const.CAT_MAMMALS +
                ",'Palawan bearded pig', " + R.drawable.mammals_palawan_bearded_pig + ", 0, " + "'Sus ahoenobarbus', 'The Palawan bearded pig is a species of in the pig genus endemic to the Philippines, where it can only be found on the archipelago of islands formed by Balabac, Palawan, and the Calamian Islands.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (19, " + Const.CAT_MAMMALS +
                ",'Aspin', " + R.drawable.mammals_aspin + ", 0, " + "'Canis lupus familiaris', 'Askals or aspins are mongrel dogs in the Philippines. The name \"askal\" is a Tagalog-derived portmanteau of asong kalye or \"street dog\" as these dogs are commonly seen wandering the streets.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (20, " + Const.CAT_MAMMALS +
                ",'Pangolin', " + R.drawable.mammals_pangolin + ", 0, " + "'Pangolin', 'The Philippine pangolin or Palawan pangolin, also known as the balintong, is a pangolin species endemic to the Palawan province of the Philippines. Its habitat includes primary and secondary forests, as well as surrounding grasslands.')");

//        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (0, " + Const.CAT_REPTILES +
//                ",'', " + R.drawable.reptiles_ + ", 0, " + "'', '')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (1, " + Const.CAT_REPTILES +
                ",'Sailfin lizard', " + R.drawable.reptiles_sailfinlizard + ", 0, " + "'Hydrosaurus pustulatus', 'The Philippine sailfin lizard, crested lizard, sail-fin lizard, sailfin water lizard, soa-soa water lizard or its native name ibid is an oviparous lizard living only in the Philippines.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (2, " + Const.CAT_REPTILES +
                ",'Crocodile', " + R.drawable.reptiles_crocodile + ", 0, " + "'Crocodylus mindorensis', 'The Philippine crocodile, also known as the Mindoro crocodile, the Philippine freshwater crocodile or locally, bukarot, is one of two species of crocodiles found in the Philippines; the other is the larger saltwater crocodile.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (3, " + Const.CAT_REPTILES +
                ",'Cobra', " + R.drawable.reptiles_cobra + ", 0, " + "'Naja philippinensis', 'The Philippine cobra also called northern Philippine cobra, is a stocky, highly venomous species of spitting cobra native to the northern regions of the Philippines.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (4, " + Const.CAT_REPTILES +
                ",'Grays monitor', " + R.drawable.reptiles_graymonitor + ", 0, " + "'Varanus olivaceus', 'The Grays monitor is a large monitor lizard known only from lowland dipterocarp forest in southern Luzon, Catanduanes, and Polillo Island, all islands in the Philippines. It is also known as Grays monitor lizard, butaan, and ornate monitor.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (5, " + Const.CAT_REPTILES +
                ",'Common house gecko', " + R.drawable.reptiles_housegecko + ", 0, " + "'Hemidactylus frenatus', 'The common house gecko, is a reptile native of Southeast Asia. It is also known as the Pacific house gecko, the Asian house gecko, house lizard, or Moon Lizard.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (6, " + Const.CAT_REPTILES +
                ",'Samar Cobra', " + R.drawable.reptiles_samarcobra + ", 0, " + "'Naja samarensis', 'The Samar cobra also called Peters cobra, southern Philippine cobra or Visayan cobra, is a highly venomous species of spitting cobra native to the Visayas and Mindanao island groups of the Philippines.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (7, " + Const.CAT_REPTILES +
                ",'Forest Turtle', " + R.drawable.reptiles_forestturtle + ", 0, " + "'Siebenrockiella leytensis', 'Siebenrockiella leytensis is a species of freshwater turtle endemic to the Philippines. It is classified as critically endangered. It is known as the Philippine forest turtle, the Philippine pond turtle, the Palawan turtle, or the Leyte pond turtle.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (8, " + Const.CAT_REPTILES +
                ",'Draco', " + R.drawable.reptiles_draco + ", 0, " + "'Draco', 'Draco is a genus of agamid lizards that are also known as flying lizards, flying dragons or gliding lizards.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (9, " + Const.CAT_REPTILES +
                ",'Amboina box turtle', " + R.drawable.reptiles_amboinaboxturtle + ", 0, " + "'Cuora amboinensis', 'These turtles have blackish-brown to olive brown colored shells that are not as ornate as many other box turtles. All have a blackish olive head with three yellow stripes on the side.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (10, " + Const.CAT_REPTILES +
                ",'Yellow-lipped sea krait', " + R.drawable.reptiles_yellowlippedseakrait + ", 0, " + "'Laticauda colubrina', 'The yellow-lipped sea krait, also known as the banded sea krait, colubrine sea krait, is a species of venomous sea snake found in tropical Indo-Pacific oceanic waters.')");

        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (11, " + Const.CAT_REPTILES +
                ",'Sphenomorphus', " + R.drawable.reptiles_sphenomorphus + ", 0, " + "'Sphenomorphus', 'The genus Sphenomorphus ñ vernacularly known as the common skinks ñ currently serves as a \"wastebin taxon\" for a large number of skinks.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (12, " + Const.CAT_REPTILES +
                ",'Gekko', " + R.drawable.reptiles_gekko + ", 0, " + "'Gekko', 'Gekko is a genus of colorful and diverse Southeast Asian geckos commonly known as true geckos or calling geckos.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (13, " + Const.CAT_REPTILES +
                ",'Yellow-headed water monitor', " + R.drawable.reptiles_yellowheadwatermontiro + ", 0, " + "'Varanus cumingi', 'The yellow-headed water monitor (Varanus cumingi), also commonly known as the Philippine water monitor or Cumings water monitor, is a large species of monitor lizard previously recognized as a subspecies of the water monitor')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (14, " + Const.CAT_REPTILES +
                ",'Chrysopelea paradisi', " + R.drawable.reptiles_chrysopeleaparadisi + ", 0, " + "'Chrysopelea paradisi', 'SphenomorphusParadise tree snake or Paradise flying snake, Chrysopelea paradisi, is a species of snake found in southeastern Asia. It can, like all species of its genus Chrysopelea, glide by stretching the body into a flattened strip using its ribs.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (15, " + Const.CAT_REPTILES +
                ",'Pit Viper', " + R.drawable.reptiles_pitviper + ", 0, " + "'Crotalinae', 'The Crotalinae, commonly known as pit vipers, crotaline snakes, or pit adders, are a subfamily of venomous vipers')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (16, " + Const.CAT_REPTILES +
                ",'Softshell turtle', " + R.drawable.reptiles_softshellturtle + ", 0, " + "'Pelochelys cantorii', 'Cantors giant softshell turtle or Asian giant softshell turtle is a species of freshwater turtle native to Southeast Asia. It has been considered the largest extant freshwater turtle.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (17, " + Const.CAT_REPTILES +
                ",'Coral reef snake', " + R.drawable.reptiles_coralreefsnakes + ", 0, " + "'Hydrophiinae', 'The Hydrophiinae, commonly known as sea snakes or coral reef snakes, are a subfamily of venomous elapid snakes that inhabit marine environments for most or all of their lives.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (18, " + Const.CAT_REPTILES +
                ",'Typhlopidae', " + R.drawable.reptiles_typhlopidae + ", 0, " + "'Typhlopidae', 'The Typhlopidae are a family of blind snakes. They are found mostly in the tropical regions of Africa, Asia, the Americas, and all mainland Australia and various islands.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (19, " + Const.CAT_REPTILES +
                ",'Hydrophis semperi', " + R.drawable.reptiles_semperi + ", 0, " + "'Hydrophis semperi', 'Hydrophis semperi, commonly known as Garmans sea snake, the Lake Taal snake, or the Philippine freshwater sea snake, is a rare species of venomous sea snake found only in a single lake on the island of Luzon in the Philippines.')");
        db.execSQL("INSERT INTO TBL_ANIMALS (id, category, name, drawable, isSolved, scientificName, description) VALUES (20, " + Const.CAT_REPTILES +
                ",'Many-striped Skink', " + R.drawable.reptiles_skink + ", 0, " + "'Eutropis multifasciata', 'Eutropis multifasciata, commonly known as the East Indian brown mabuya, many-lined sun skink, many-striped skink, common sun skink or as golden skink, is a species of skink')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS TBL_DESCRIPTION");

        onCreate(db);
    }

    public static SQLiteDatabase getReadableSQL(Context ctx) {
        return getInstance(ctx).getReadableDatabase();
    }

    public static SQLiteDatabase getWritableSQL(Context ctx) {
        return getInstance(ctx).getWritableDatabase();
    }

    public static AnimalItem getAnimalItem(Context ctx, int category, int index) {

        SQLiteDatabase db = getReadableSQL(ctx);
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, null, "category =? AND id =?", new String[]{String.valueOf(category), String.valueOf(index)}, null, null, null);
        Log.d("EXB", "count: " + cursor.getCount());
        if (cursor.moveToNext())
            return new AnimalItem(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getString(5), cursor.getString(6));

//        cursor.close();

        return null;
    }

    public static List<String> getAnimalNames(Context ctx, int category, int index) {

        List<String> animalNames = new ArrayList<>();

        SQLiteDatabase db = getReadableSQL(ctx);

        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, new String[]{"name"}, "category =? AND id !=?", new String[]{String.valueOf(category), String.valueOf(index)}, null, null, null);
        while (cursor.moveToNext()) {
            animalNames.add(cursor.getString(0));
        }
        return animalNames;
    }

    public static void updateAnimals(Context ctx, int category, int id) {

        SQLiteDatabase db = getWritableSQL(ctx);
        ContentValues values = new ContentValues();
        values.put("isSolved", 1);
        db.update(TABLE_NAME, values, "category =? AND id =?", new String[]{String.valueOf(category), String.valueOf(id)});


    }
}
