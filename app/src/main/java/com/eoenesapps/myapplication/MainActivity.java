package com.eoenesapps.myapplication;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceManager;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.eoenesapps.myapplication.SettingsActivity.cheatsActivated;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences.OnSharedPreferenceChangeListener listener;



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.preference.PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        final SharedPreferences sharedPref =
                androidx.preference.PreferenceManager
                        .getDefaultSharedPreferences(this);
        String currentPackType = sharedPref.getString(SettingsActivity.PACK_SWITCH, "1");

        if(currentPackType.equals("1")){//Bird sounds
            arrayHolderBoi = birdList;
            arrayNameHolderBoi = bird2List;
        }
        else if(currentPackType.equals("2")){//Random sounds
            arrayHolderBoi = list;
            arrayNameHolderBoi = list2;

        }
        else if(currentPackType.equals("3")){//Musical instrument
            arrayHolderBoi = musicalInstruments;
            arrayNameHolderBoi = musical2Instruments;
        }
        else{
            arrayHolderBoi = list;
            arrayNameHolderBoi = list2;
            System.out.println("You messed up...");
        }


    }


    public static int list[] = //SoundPack: Random Sounds
            {R.raw.doorknock, R.raw.heavyrain, R.raw.morsecode, R.raw.spaceship, R.raw.alarm, R.raw.applause, R.raw.bell, R.raw.saw, R.raw.gong, R.raw.clock, R.raw.cracklingfire, R.raw.thunder, R.raw.dragon, R.raw.dogbarking, R.raw.dialtone, R.raw.toilet};

    public static String list2[] = //SoundPack: Random Sounds
            {"Door Knocking", "Heavy Rain", "Morse Code", "Spaceship", "Alarm", "Applause", "Bell", "Saw", "Gong", "Clock", "Fire", "Thunder", "Dragon", "Dog", "Dial Tone", "Toilet"};

    public static int arrayHolderBoi[];
    //= list;
    public static String arrayNameHolderBoi[];
    //= list2;
    public static int musicalInstruments[] = //SoundPack: Musical Instruments
            {R.raw.doorknock, R.raw.heavyrain, R.raw.morsecode, R.raw.spaceship, R.raw.alarm, R.raw.applause};

    public static String musical2Instruments[] = //SoundPack: Random Sounds
            {"Door Knocking", "Heavy Rain", "Morse Code", "Spaceship", "Alarm", "Applause"};

    /* public int list[] = //SoundPack: Birds
             {R.raw.l00300aegoliusacadicus477110, R.raw.l00400vireophiladelphicus474833, R.raw.l00592ammodramusmaritimus487417, R.raw.l00638aythyavalisineria371522, R.raw.l00767poecilerufescens420593, R.raw.l00793passerinaversicolor252856, R.raw.l00914botauruslentiginosus451067, R.raw.l00917calcariuslapponicus420217, R.raw.l01183chordeilesacutipennis109164, R.raw.l01356dryobatesnuttallii408009, R.raw.l01774setophagacitrina478573, R.raw.l02003colinusvirginianus413574, R.raw.l02044lampornisclemenciae345565, R.raw.l02243leiothlypiscrissalis383125, R.raw.l02362mergusserrator141724, R.raw.l02520pluvialisdominica323107, R.raw.l02599myiarchuscinerascens433791, R.raw.l02985dumetellacarolinensis469539, R.raw.l03529amphispizaquinquestriata435744, R.raw.l03659empidonaxwrightii385803, R.raw.l03671setophagacastanea480710, R.raw.l03788pirangaludoviciana441369, R.raw.l04210sporophilamorelleti147507, R.raw.l04290myadestesobscurus385391, R.raw.l04399icterusgalbula444946, R.raw.l04968melospizageorgiana475100, R.raw.l06545limosalapponica135141, R.raw.l06559corvusbrachyrhynchos481136, R.raw.l06784polioptilamelanura475184, R.raw.l06883tringamelanoleuca408113, R.raw.l06913psaltriparusminimus215758, R.raw.l07018contopuspertinax380637, R.raw.l07123psiloscopsflammeolus428231, R.raw.l07533cardinalissinuatus474136, R.raw.l07622geothlypisformosa478512, R.raw.l07925drepaniscoccinea453296, R.raw.l08311spinustristis462056, R.raw.l08624icterusspurius487505, R.raw.l08688selasphorussasin125251, R.raw.l08897pluvialissquatarola316265, R.raw.l09306baeolophusbicolor375653, R.raw.l09317motacillatschutschensis141709, R.raw.l09407cyanocoraxluxuosus155030, R.raw.l09437myiodynastesluteiventris269311, R.raw.l09502porzanacarolina418912, R.raw.l09648loxopscaeruleirostris219961, R.raw.l09697mniotiltavaria478569, R.raw.l09723sternaforsteri406598, R.raw.l09737myiopsittamonachus316273, R.raw.l09767ixoreusnaevius416081, R.raw.l09899acridotherestristis208162, R.raw.l10158accipitercooperii11627, R.raw.l10370melospizalincolnii488460, R.raw.l10530micrathenewhitneyi363557, R.raw.l10815coccyzusminor315493, R.raw.l10857setophagachrysoparia317249, R.raw.l10905numeniusamericanus347639, R.raw.l11131setophagastriata488509, R.raw.l11170pycnonotusjocosus131477, R.raw.l11214acrocephalusfamiliaris144819, R.raw.l11312catharusfuscescens425801, R.raw.l11373aramusguarauna331321, R.raw.l11593bubovirginianus442353, R.raw.l12112melanittaamericana69921, R.raw.l12217hylocichlamustelina486244, R.raw.l12425centrocercusminimus75075, R.raw.l12518coccyzusamericanus100137, R.raw.l12855setophagaamericana488523, R.raw.l13451ixobrychusexilis143608, R.raw.l13508vireoflavifrons477608, R.raw.l14261contopuscooperi443464, R.raw.l14349stelgidopteryxserripennis420314, R.raw.l14352calidrisbairdii185621, R.raw.l14423juncohyemalis483708, R.raw.l14969cypseloidesniger14997, R.raw.l15042amaziliaberyllina145961, R.raw.l15060toxostomalongirostre176252, R.raw.l15555melozoneaberti247614, R.raw.l15633tringaflavipes356449, R.raw.l16031brantacanadensis418340, R.raw.l16197leptotilaverreauxi277692, R.raw.l16247toxostomacrissale468925, R.raw.l16322sturnellaneglecta372033, R.raw.l16601chasiempissclateri27337, R.raw.l16747coturnicopsnoveboracensis469205, R.raw.l17270empidonaxvirescens478572, R.raw.l17865pipilochlorurus482213, R.raw.l17869euphaguscyanocephalus377880, R.raw.l18126icteruscucullatus484403, R.raw.l18446parkesianoveboracensis380120, R.raw.l18677hesperiphonavespertina476309, R.raw.l18846nyctidromusalbicollis285306, R.raw.l19141cynanthuslatirostris187631, R.raw.l19242arremonopsrufivirgatus401312, R.raw.l19595pheucticusmelanocephalus370065, R.raw.l19603toxostomacurvirostre402949, R.raw.l19849ammodramusleconteii282767, R.raw.l20270crithagramozambica191213, R.raw.l20324catherpesmexicanus461561, R.raw.l20637sittapygmaea313506, R.raw.l20927seiurusaurocapilla444964, R.raw.l20940melanerpesformicivorus481135, R.raw.l21071phylloscopusborealis421943, R.raw.l21120tachycinetathalassina261347, R.raw.l21242aythyaaffinis347797, R.raw.l21378centrocercusurophasianus368675, R.raw.l21694pipiloerythrophthalmus444954, R.raw.l21839tyrannusforficatus323788, R.raw.l22066zenaidaasiatica233404, R.raw.l22068tyrannustyrannus323774, R.raw.l22170falcipenniscanadensis269222, R.raw.l22322chaeturapelagica487256, R.raw.l22328calidrispusilla424198, R.raw.l22337dendragapusobscurus361839, R.raw.l22507crotophagasulcirostris299108, R.raw.l22794calidrisalba406416, R.raw.l22854callipeplacalifornica481114, R.raw.l23069aphelocomainsularis27719, R.raw.l23123myzomelacardinalis317190, R.raw.l23183icterusgraduacauda358991, R.raw.l23229megascopsasio478062, R.raw.l23331hemignathuswilsoni306424, R.raw.l23344vireoaltiloquus197264, R.raw.l23786empidonaxalnorum479504, R.raw.l24072haemorhouspurpureus486249, R.raw.l24362motacillaalba103189, R.raw.l24737hirundorustica481190, R.raw.l24886aphelocomawollweberi165770, R.raw.l24925phainopeplanitens465654, R.raw.l24988perdixperdix189205, R.raw.l25152basileuterusrufifrons279157, R.raw.l25472picoidesdorsalis353490, R.raw.l25525setophagadominica411428, R.raw.l25526petrochelidonpyrrhonota468931, R.raw.l25660passerellaunalaschcensis416076, R.raw.l25693passerellamegarhyncha445160, R.raw.l25804ammodramuscaudacutus433079, R.raw.l26049icterusgularis306097, R.raw.l26145tyrannuscouchii404720, R.raw.l26315aphelocomacoerulescens316286, R.raw.l26316gallinagodelicata469574, R.raw.l26339setophagapalmarum410779, R.raw.l27287tachycinetabicolor354703, R.raw.l27763melanerpescarolinus343930, R.raw.l28224zosteropsrotensis113740, R.raw.l28344passerdomesticus485516, R.raw.l28589ammodramushenslowii475142, R.raw.l28640corvuscorax213233, R.raw.l28826athenecunicularia382876, R.raw.l29097butoridesvirescens469642, R.raw.l29121cardinaliscardinalis234663, R.raw.l29227acanthishornemanni142566, R.raw.l29326pyrocephalusobscurus466755, R.raw.l29341callipeplasquamata435473, R.raw.l29586toxostomaredivivum444658, R.raw.l30086dryobatesscalaris196553, R.raw.l30193anascarolinensis459927, R.raw.l30549selasphoruscalliope412986, R.raw.l30737melozonefusca323280, R.raw.l31256porphyriomartinica1147, R.raw.l31274setophagamagnolia484389, R.raw.l31845buteolineatus105723, R.raw.l32161antrostomusridgwayi377681, R.raw.l32334tachybaptusdominicus161321, R.raw.l32386patagioenasleucocephala145946, R.raw.l32671quiscalusquiscula371524, R.raw.l32925leiothlypisluciae474141, R.raw.l33008myadestestownsendi488461, R.raw.l33115peucaeabotterii419050, R.raw.l33143actitismacularius444487, R.raw.l33192palmeriadolei122342, R.raw.l33338geothlypisphiladelphia448187, R.raw.l33345spatulaclypeata368726, R.raw.l33645spizellabreweri483211, R.raw.l33742colapteschrysoides382603, R.raw.l33885pandionhaliaetus369949, R.raw.l33959turdusgrayi277329, R.raw.l34045thryophilussinaloa279006, R.raw.l34166ralluselegans358056, R.raw.l34275molothrusbonariensis365177, R.raw.l34402loxioidesbailleui146104, R.raw.l34857patagioenasflavirostris276871, R.raw.l34906oxyurajamaicensis109911, R.raw.l35636sphyrapicusruber408661, R.raw.l35893molothrusater482295, R.raw.l36241cyanocittacristata382356, R.raw.l36341columbinapasserina414024, R.raw.l36588marecapenelope41859, R.raw.l36674baeolophusridgwayi394807, R.raw.l36686phalaropusfulicarius406388, R.raw.l36728charadriusvociferus408273, R.raw.l36886gaviapacifica406246, R.raw.l37037oporornisagilis480915, R.raw.l37091dolichonyxoryzivorus477784, R.raw.l37215calamospizamelanocorys263143, R.raw.l37500leucosticteatrata143749, R.raw.l37789phasianuscolchicus179662, R.raw.l37898setophagaruticilla478575, R.raw.l38162spinuslawrencei483003, R.raw.l38239asiootus233963, R.raw.l38286toxostomarufum483033, R.raw.l38559spilopeliachinensis205837, R.raw.l38632himationesanguinea454885, R.raw.l38686strixnebulosa483006, R.raw.l38692leiothlypiscelata482871, R.raw.l38776calypteanna473411, R.raw.l39003sonusnaturalis475622, R.raw.l39109catharusbicknelli469601, R.raw.l39308ralluscrepitans64539, R.raw.l39399loxopsmana175502, R.raw.l39456buteoplagiatus278723, R.raw.l39563somateriaspectabilis141727, R.raw.l39665vireoplumbeus483015, R.raw.l39813sialiamexicana172425, R.raw.l39856corvusossifragus432883, R.raw.l39894troglodytesaedon440012, R.raw.l40078protonotariacitrea478658, R.raw.l40376aphelocomawoodhouseii215457, R.raw.l40528setophagatownsendi475113, R.raw.l40537calyptecostae203734, R.raw.l40602dendragapusfuliginosus414091, R.raw.l40714archilochusalexandri104902, R.raw.l40935gaviastellata177221, R.raw.l41025prognesubis480707, R.raw.l41098antrostomusvociferus436196, R.raw.l41284myadestespalmeri144892, R.raw.l41285columbalivia485507, R.raw.l42226baeolophusinornatus481143, R.raw.l42247glaucidiumcalifornicum409946, R.raw.l42291contopusvirens465082, R.raw.l42431tringasolitaria406668, R.raw.l42432leucophaeusatricilla1154, R.raw.l42438laruscalifornicus125272, R.raw.l42484peucedramustaeniatus410934, R.raw.l42708sturnellamagna454687, R.raw.l43340columbinainca360998, R.raw.l43400zonotrichiaatricapilla481153, R.raw.l43405setophagapinus476138, R.raw.l43533foulehaiocarunculatus180849, R.raw.l43571antigonecanadensis316293, R.raw.l43682sittapusilla316289, R.raw.l43749plectrophenaxnivalis416067, R.raw.l44063limnodromusscolopaceus452766, R.raw.l44112pirangarubra466198, R.raw.l44169haemorhousmexicanus440009, R.raw.l44265sialiasialis481623, R.raw.l44280parabuteounicinctus1325, R.raw.l44422pavocristatus452046, R.raw.l44497buteojamaicensis1140, R.raw.l44573passerinaamoena483011, R.raw.l44585mimuspolyglottos470300, R.raw.l44604megacerylealcyon368940, R.raw.l44811contopussordidulus422905, R.raw.l44902numeniustahitiensis406101, R.raw.l45097salpinctesobsoletus451709, R.raw.l45266telespizaultima144829, R.raw.l45370vireoolivaceus486531, R.raw.l45375eremophilaalpestris482274, R.raw.l45510empidonaxhammondii424050, R.raw.l45553tetraogallushimalayensis255349, R.raw.l45558tyrannusvociferans392999, R.raw.l45561catharusustulatus441361, R.raw.l45603cyrtonyxmontezumae367668, R.raw.l45604amphispizabilineata484906, R.raw.l45614nucifragacolumbiana391598, R.raw.l45910cinclusmexicanus400124, R.raw.l46651vireohuttoni405621, R.raw.l46776setophagaaestiva465395, R.raw.l47047acanthisflammea141708, R.raw.l47265pooecetesgramineus482289, R.raw.l47387numeniusphaeopus356265, R.raw.l47764laniusludovicianus297969, R.raw.l47769parkesiamotacilla474097, R.raw.l47934surniaulula67157, R.raw.l48031lagopusleucura438516, R.raw.l48195limnodromusgriseus460724, R.raw.l48243charadriussemipalmatus323096, R.raw.l48501troglodytespacificus482845, R.raw.l48705passerellaschistacea369904, R.raw.l48771catharusguttatus487926, R.raw.l48882cygnuscolumbianus406440, R.raw.l49019ralluslimicola359349, R.raw.l49500empidonaxaffinis325674, R.raw.l49620bombycillacedrorum476658, R.raw.l49818setophagaauduboni103111, R.raw.l49920spinuspinus349759, R.raw.l50168melozonecrissalis477168, R.raw.l50555poecilehudsonicus322979, R.raw.l50679anasplatyrhynchos357023, R.raw.l50917aplonisatrifusca314958, R.raw.l51227setophagacaerulescens487497, R.raw.l51628calidrismaritima452313, R.raw.l51694recurvirostraamericana1150, R.raw.l51768icterusbullockii367271, R.raw.l51838passermontanus210878, R.raw.l51858quiscalusmajor387127, R.raw.l52030ardeaherodias419194, R.raw.l52103spizellapasserina483740, R.raw.l52356lophodytescucullatus90146, R.raw.l52594geothlypistolmiei483002, R.raw.l52670calidrisminutilla322794, R.raw.l52712sittacanadensis461299, R.raw.l52831spizelloidesarborea356271, R.raw.l52898setophagavirens380129, R.raw.l52941colaptesauratus444653, R.raw.l53107empidonaxfulvifrons324275, R.raw.l53711calidrisruficollis182179, R.raw.l54015sayornisphoebe323217, R.raw.l54110coccyzuserythropthalmus241134, R.raw.l54349antrostomusarizonae253148, R.raw.l54350oreoscoptesmontanus320563, R.raw.l54386empidonaxminimus489102, R.raw.l54807setophagapensylvanica444951, R.raw.l55028antrostomuscarolinensis383108, R.raw.l55066ammodramussavannarum480706, R.raw.l55164agelaiustricolor393990, R.raw.l55273loxiacurvirostra488680, R.raw.l55299strixoccidentalis239658, R.raw.l55346aechmophorusoccidentalis205821, R.raw.l55353turdusmigratorius480065, R.raw.l55413amaziliayucatanensis302265, R.raw.l55483amaziliavioliceps71377, R.raw.l55587aegoliusfunereus407879, R.raw.l55627geothlypispoliocephala5640, R.raw.l55691passerinacaerulea418911, R.raw.l56259vireosolitarius486055, R.raw.l56499zenaidamacroura382741, R.raw.l57392podicepsauritus345549, R.raw.l57615calidrisalpina323109, R.raw.l57726limosafedoa163166, R.raw.l57761bombycillagarrulus450556, R.raw.l57765setophagapetechia307530, R.raw.l57980mitrephanesphaeocercus380643, R.raw.l58131pirangabidentata329709, R.raw.l58613corvuskubaryi254699, R.raw.l58708vireovicinior481046, R.raw.l59174vermivorachrysoptera445079, R.raw.l59321pitangussulphuratus440256, R.raw.l59480oceanodromatristrami441709, R.raw.l59586calidrismelanotos426277, R.raw.l59832vireoatricapilla477409, R.raw.l60115oreortyxpictus408812, R.raw.l60126chlorodrepanisstejnegeri210213, R.raw.l60284ammodramusbairdii335553, R.raw.l60591pheucticusludovicianus479490, R.raw.l60809empidonaxflaviventris187564, R.raw.l60903oenantheoenanthe420221, R.raw.l61005dryobatespubescens89855, R.raw.l61417paroariacoronata314703, R.raw.l61665myiarchusnuttingi252883, R.raw.l61668phoebastriaimmutabilis164431, R.raw.l61712streptopeliadecaocto481134, R.raw.l61960sturnusvulgaris423323, R.raw.l62080anthusspragueii355077, R.raw.l62097patagioenasfasciata303691, R.raw.l62202reguluscalendula322942, R.raw.l62273cistothoruspalustris481193, R.raw.l63142strixvaria433223, R.raw.l63876myioboruspictus488517, R.raw.l63897gymnorhinuscyanocephalus378149, R.raw.l64046tympanuchuspallidicinctus216647, R.raw.l64255leuconotopicusvillosus325121, R.raw.l64718calidrisvirgata243979, R.raw.l64802setophagafusca489097, R.raw.l64810helmitherosvermivorum460696, R.raw.l65189icteriavirens484785, R.raw.l65192pterodromahypoleuca135835, R.raw.l65205geococcyxcalifornianus463262, R.raw.l65283sternulaantillarum130763, R.raw.l65423calidrismauri149251, R.raw.l65647poecilesclateri317973, R.raw.l65707melanerpeserythrocephalus135670, R.raw.l65873vireobellii277055, R.raw.l65903setophagagraciae478205, R.raw.l66015aphelocomacalifornica454467, R.raw.l66179vireocassinii483027, R.raw.l66510pinicolaenucleator369903, R.raw.l66861passerinaciris277613, R.raw.l67126chasiempissandwichensis175246, R.raw.l67247geothlypistrichas444952, R.raw.l67310scolopaxminor464355, R.raw.l67391setophaganigrescens436811, R.raw.l67394pycnonotuscafer454892, R.raw.l67488selasphorusrufus174754, R.raw.l67702zosteropsjaponicus175490, R.raw.l68095setophagaoccidentalis436827, R.raw.l68309podicepsgrisegena354608, R.raw.l68886icteruspectoralis263052, R.raw.l68898spizellapallida419201, R.raw.l68931calcariuspictus356214, R.raw.l68988ammodramusnelsoni445085, R.raw.l69157selasphorusplatycercus374078, R.raw.l69292estrildaastrild368429, R.raw.l69778megascopskennicottii414263, R.raw.l69927gaviaimmer457431, R.raw.l70002spinuspsaltria288470, R.raw.l70435limnothlypisswainsonii478780, R.raw.l70646lusciniasvecica416336, R.raw.l70981myiarchustyrannulus380720, R.raw.l70993horornisdiphone27362, R.raw.l71457poecilecarolinensis481972, R.raw.l71593myiarchustuberculifer315696, R.raw.l71617alectorischukar269241, R.raw.l71798vireogriseus478579, R.raw.l72132melanerpesaurifrons100142, R.raw.l72407leiothlypisperegrina480715, R.raw.l72493tyrannuscrassirostris238607, R.raw.l72845spizaamericana444078, R.raw.l73170juncophaeonotus488668, R.raw.l73246leiothlypisruficapilla428341, R.raw.l73523charadriusmelodus369941, R.raw.l73890xanthocephalusxanthocephalus411393, R.raw.l73944buteoplatypterus479508, R.raw.l74272pirangahepatica373062, R.raw.l74957streptopeliaroseogrisea375491, R.raw.l74972empidonaxoberholseri385778, R.raw.l75071chlorodrepanisflava454888, R.raw.l75431glaucidiumgnoma283089, R.raw.l75774chordeilesminor370484, R.raw.l75973podilymbuspodiceps459166, R.raw.l75977tyrannusverticalis443467, R.raw.l76472geopeliastriata328022, R.raw.l76618eugenesfulgens324508, R.raw.l76883cardellinapusilla482705, R.raw.l77311myzomelarubratra403089, R.raw.l77798aplonistabuensis180842, R.raw.l77850tympanuchuscupido468245, R.raw.l77912pseudonestorxanthophrys123887, R.raw.l78111agelaiusphoeniceus482986, R.raw.l78211leiothlypisvirginiae422902, R.raw.l78556megascopstrichopsis391565, R.raw.l78565artemisiospizabelli413132, R.raw.l78607ortalisvetula147484, R.raw.l79104passerculussandwichensis354731, R.raw.l79275myiarchuscrinitus481817, R.raw.l79303calidrisptilocnemis406192, R.raw.l79459petrochelidonfulva321333, R.raw.l79636larushyperboreus406443, R.raw.l80133laniusborealis91968, R.raw.l80260empidonaxdifficilis483750, R.raw.l80294spizellaatrogularis483157, R.raw.l80381peucaeacarpalis489322, R.raw.l80792empidonaxtraillii388445, R.raw.l81045loxialeucoptera165652, R.raw.l81444sphyrapicusnuchalis311849, R.raw.l81497anthusrubescens277562, R.raw.l81569leucophaeuspipixcan352969, R.raw.l82411aeronautessaxatalis368921, R.raw.l82488mysterymystery488157, R.raw.l82532bartramialongicauda104331, R.raw.l82776auriparusflaviceps316865, R.raw.l82861fregataminor116571, R.raw.l83058phalaenoptilusnuttallii461827, R.raw.l83132poecilegambeli199595, R.raw.l83163quiscalusmexicanus452996, R.raw.l83180icteruspustulatus253181, R.raw.l83262ptilinopusroseicapilla394600, R.raw.l83377sayornissaya386336, R.raw.l83791nycticoraxnycticorax152401, R.raw.l83832zonotrichiaalbicollis467600, R.raw.l83887trogonelegans345783, R.raw.l83932lagopuslagopus410894, R.raw.l84000tringasemipalmata444585, R.raw.l84197charadriusmontanus131896, R.raw.l84286calidrishimantopus203568, R.raw.l84520icterusparisorum265054, R.raw.l84610certhiaamericana482568, R.raw.l84859francolinusfrancolinus175524, R.raw.l85046setophagadiscolor478577, R.raw.l85063setophagapitiayumi478448, R.raw.l85117setophagakirtlandii467295, R.raw.l85231cistothorusstellaris478450, R.raw.l85256artemisiospizanevadensis462885, R.raw.l85443peucaeaaestivalis414015, R.raw.l86040clangulahyemalis406365, R.raw.l86061aechmophorusclarkii367258, R.raw.l86339pyrocephalusrubinus29069, R.raw.l86512cepphuscolumba420374, R.raw.l86632larusdelawarensis332148, R.raw.l86651thryothorusludovicianus487506, R.raw.l86873alaudaarvensis175235, R.raw.l86887perisoreuscanadensis28872, R.raw.l87160zonotrichialeucophrys328629, R.raw.l87261elaeniachilensis392829, R.raw.l87359dryocopuspileatus351542, R.raw.l87397catharusaurantiirostris277476, R.raw.l87539baeolophuswollweberi465416, R.raw.l87959tyrannusmelancholicus383699, R.raw.l88212calcariusornatus341859, R.raw.l88379vermivoracyanoptera445083, R.raw.l88645cyanocittastelleri461544, R.raw.l88769pluvialisfulva420229, R.raw.l88973polioptilacaerulea481964, R.raw.l89264charadriuswilsonia239636, R.raw.l89467buteogallusanthracinus80617, R.raw.l89912zonotrichiaquerula70460, R.raw.l90011euphaguscarolinus468246, R.raw.l90037molothrusaeneus368475, R.raw.l90119vireogilvus478702, R.raw.l90309baeolophusatricristatus163949, R.raw.l90321chlorodrepanisvirens27323, R.raw.l90362laterallusjamaicensis419372, R.raw.l90702toxostomabendirei409670, R.raw.l90756campylorhynchusbrunneicapillus475569, R.raw.l90785chasiempisibidis410155, R.raw.l90896empidonaxoccidentalis422197, R.raw.l91290phoebastrianigripes116357, R.raw.l91434troglodyteshiemalis484393, R.raw.l91640loxopscoccineus175511, R.raw.l91715himantopusmexicanus1149, R.raw.l91741acrocephalushiwae351544, R.raw.l91923gaviaadamsii185362, R.raw.l92200setophagacoronata475102, R.raw.l92253plectrophenaxhyperboreus331841, R.raw.l92270thryomanesbewickii484931, R.raw.l92595myadestesoccidentalis37017, R.raw.l92780lagopusmuta406103, R.raw.l92919podicepsnigricollis323218, R.raw.l92924passerinacyanea481963, R.raw.l93039passerellailiaca461342, R.raw.l93123melanerpesuropygialis408967, R.raw.l93156cardellinacanadensis484391, R.raw.l93358regulussatrapa484388, R.raw.l93485toxostomalecontei469887, R.raw.l93573calidriscanutus185586, R.raw.l93965chaeturavauxi264029, R.raw.l94041pirangaolivacea466880, R.raw.l94211leuconotopicusborealis314693, R.raw.l94476myioborusminiatus474206, R.raw.l94496haemorhouscassinii436813, R.raw.l94535sialiacurrucoides205426, R.raw.l94659tympanuchusphasianellus368619, R.raw.l94779picahudsonia15509, R.raw.l94981corvuscaurinus420594, R.raw.l95099polioptilanigriceps76315, R.raw.l95229poecileatricapillus420409, R.raw.l95302duculapacifica180841, R.raw.l95341cardellinarubrifrons299339, R.raw.l95606setophagacerulea479915, R.raw.l95639meleagrisgallopavo465131, R.raw.l95851tyrannusdominicensis196228, R.raw.l95928setophagatigrina466992, R.raw.l95971peucaeacassinii477195, R.raw.l96197pipilomaculatus481125, R.raw.l96484glaucidiumbrasilianum368470, R.raw.l96678chondestesgrammacus423752, R.raw.l96889clytorhynchusvitiensis181026, R.raw.l97253melospizamelodia450245, R.raw.l97456chordeilesgundlachii102918, R.raw.l97736gallinulagaleata187977, R.raw.l97826anaswyvilliana234981, R.raw.l98102vireoflavoviridis481366, R.raw.l98174charadriusnivosus419959, R.raw.l98237sittacarolinensis475398, R.raw.l98245chamaeafasciata312612, R.raw.l98370rhynchophanesmccownii371869, R.raw.l98846aimophilaruficeps426309, R.raw.l98872callipeplagambelii487941, R.raw.l98935magummaparva210206, R.raw.l99549sayornisnigricans486800, R.raw.l99729catharusminimus420272, R.raw.l99734camptostomaimberbe367158, R.raw.l99918spizellapusilla475033};
 */
    public static int birdList[] =
            {R.raw.l00300aegoliusacadicus477110, R.raw.l00400vireophiladelphicus474833, R.raw.l00592ammodramusmaritimus487417, R.raw.l00638aythyavalisineria371522};
    /* public String list2[] = //SoundPack: Birds
            {"Northern Saw-whet Owl", "Philadelphia Vireo", "Seaside Sparrow", "Canvasback", "Chestnut-backed Chickadee", "Varied Bunting", "American Bittern", "Lapland Longspur", "Lesser Nighthawk", "Nuttall's Woodpecker", "Hooded Warbler", "Northern Bobwhite", "Blue-throated Mountaingem", "Colima Warbler", "Red-breasted Merganser", "American Golden Plover", "Ash-throated Flycatcher", "Grey Catbird", "Five-striped Sparrow", "American Grey Flycatcher", "Bay-breasted Warbler", "Western Tanager", "Morelet's Seedeater", "Omao", "Baltimore Oriole", "Swamp Sparrow", "Bar-tailed Godwit", "American Crow", "Black-tailed Gnatcatcher", "Greater Yellowlegs", "American Bushtit", "Greater Pewee", "Flammulated Owl", "Pyrrhuloxia", "Kentucky Warbler", "Iiwi", "American Goldfinch", "Orchard Oriole", "Allen's Hummingbird", "Grey Plover", "Tufted Titmouse", "Eastern Yellow Wagtail", "Green Jay", "Sulphur-bellied Flycatcher", "Sora", "Akekee", "Black-and-white Warbler", "Forster's Tern", "Monk Parakeet", "Varied Thrush", "Common Myna", "Cooper's Hawk", "Lincoln's Sparrow", "Elf Owl", "Mangrove Cuckoo", "Golden-cheeked Warbler", "Long-billed Curlew", "Blackpoll Warbler", "Red-whiskered Bulbul", "Millerbird", "Veery", "Limpkin", "Great Horned Owl", "Black Scoter", "Wood Thrush", "Gunnison Grouse", "Yellow-billed Cuckoo", "Northern Parula", "Least Bittern", "Yellow-throated Vireo", "Olive-sided Flycatcher", "Northern Rough-winged Swallow", "Baird's Sandpiper", "Dark-eyed Junco", "American Black Swift", "Berylline Hummingbird", "Long-billed Thrasher", "Abert's Towhee", "Lesser Yellowlegs", "Canada Goose", "White-tipped Dove", "Crissal Thrasher", "Western Meadowlark", "Kauai Elepaio", "Yellow Rail", "Acadian Flycatcher", "Green-tailed Towhee", "Brewer's Blackbird", "Hooded Oriole", "Northern Waterthrush", "Evening Grosbeak", "Pauraque", "Broad-billed Hummingbird", "Olive Sparrow", "Black-headed Grosbeak", "Curve-billed Thrasher", "Le Conte's Sparrow", "Yellow-fronted Canary", "Canyon Wren", "Pygmy Nuthatch", "Ovenbird", "Acorn Woodpecker", "Arctic Warbler", "Violet-green Swallow", "Lesser Scaup", "Sage Grouse", "Eastern Towhee", "Scissor-tailed Flycatcher", "White-winged Dove", "Eastern Kingbird", "Spruce Grouse", "Chimney Swift", "Semipalmated Sandpiper", "Dusky Grouse", "Groove-billed Ani", "Sanderling", "California Quail", "Island Scrub Jay", "Cardinal Myzomela", "Audubon's Oriole", "Eastern Screech Owl", "Akiapolaau", "Black-whiskered Vireo", "Alder Flycatcher", "Purple Finch", "White Wagtail", "Barn Swallow", "Mexican Jay", "Phainopepla", "Grey Partridge", "Rufous-capped Warbler", "American Three-toed Woodpecker", "Yellow-throated Warbler", "American Cliff Swallow", "Sooty Fox Sparrow", "Thick-billed Fox Sparrow", "Saltmarsh Sparrow", "Altamira Oriole", "Couch's Kingbird", "Florida Scrub Jay", "Wilson's Snipe", "Palm Warbler", "Tree Swallow", "Red-bellied Woodpecker", "Rota White-eye", "House Sparrow", "Henslow's Sparrow", "Northern Raven", "Burrowing Owl", "Green Heron", "Northern Cardinal", "Arctic Redpoll", "Vermilion Flycatcher", "Scaled Quail", "California Thrasher", "Ladder-backed Woodpecker", "Green-winged Teal", "Calliope Hummingbird", "Canyon Towhee", "Purple Gallinule", "Magnolia Warbler", "Red-shouldered Hawk", "Buff-collared Nightjar", "Least Grebe", "White-crowned Pigeon", "Common Grackle", "Lucy's Warbler", "Townsend's Solitaire", "Botteri's Sparrow", "Spotted Sandpiper", "Akohekohe", "Mourning Warbler", "Northern Shoveler", "Brewer's Sparrow", "Gilded Flicker", "Western Osprey", "Clay-colored Thrush", "Sinaloa Wren", "King Rail", "Shiny Cowbird", "Palila", "Red-billed Pigeon", "Ruddy Duck", "Red-breasted Sapsucker", "Brown-headed Cowbird", "Blue Jay", "Common Ground Dove", "Eurasian Wigeon", "Juniper Titmouse", "Red Phalarope", "Killdeer", "Pacific Loon", "Connecticut Warbler", "Bobolink", "Lark Bunting", "Black Rosy Finch", "Common Pheasant", "American Redstart", "Lawrence's Goldfinch", "Long-eared Owl", "Brown Thrasher", "Spotted Dove", "Apapane", "Great Grey Owl", "Orange-crowned Warbler", "Anna's Hummingbird", "Soundscape", "Bicknell's Thrush", "Clapper Rail", "Hawaii Creeper", "Grey Hawk", "King Eider", "Plumbeous Vireo", "Western Bluebird", "Fish Crow", "House Wren", "Prothonotary Warbler", "Woodhouse's Scrub Jay", "Townsend's Warbler", "Costa's Hummingbird", "Sooty Grouse", "Black-chinned Hummingbird", "Red-throated Loon", "Purple Martin", "Eastern Whip-poor-will", "Puaiohi", "Rock Dove", "Oak Titmouse", "Northern Pygmy Owl", "Eastern Wood Pewee", "Solitary Sandpiper", "Laughing Gull", "California Gull", "Olive Warbler", "Eastern Meadowlark", "Inca Dove", "Golden-crowned Sparrow", "Pine Warbler", "Wattled Honeyeater", "Sandhill Crane", "Brown-headed Nuthatch", "Snow Bunting", "Long-billed Dowitcher", "Summer Tanager", "House Finch", "Eastern Bluebird", "Harris's Hawk", "Indian Peafowl", "Red-tailed Hawk", "Lazuli Bunting", "Northern Mockingbird", "Belted Kingfisher", "Western Wood Pewee", "Bristle-thighed Curlew", "Rock Wren", "Nihoa Finch", "Red-eyed Vireo", "Horned Lark", "Hammond's Flycatcher", "Himalayan Snowcock", "Cassin's Kingbird", "Swainson's Thrush", "Montezuma Quail", "Black-throated Sparrow", "Clark's Nutcracker", "American Dipper", "Hutton's Vireo", "American Yellow Warbler", "Common Redpoll", "Vesper Sparrow", "Whimbrel", "Loggerhead Shrike", "Louisiana Waterthrush", "Northern Hawk-Owl", "White-tailed Ptarmigan", "Short-billed Dowitcher", "Semipalmated Plover", "Pacific Wren", "Slate-colored Fox Sparrow", "Hermit Thrush", "Tundra Swan", "Virginia Rail", "Pine Flycatcher", "Cedar Waxwing", "Audubon's Warbler", "Pine Siskin", "California Towhee", "Boreal Chickadee", "Mallard", "Samoan Starling", "Black-throated Blue Warbler", "Purple Sandpiper", "American Avocet", "Bullock's Oriole", "Eurasian Tree Sparrow", "Boat-tailed Grackle", "Great Blue Heron", "Chipping Sparrow", "Hooded Merganser", "MacGillivray's Warbler", "Least Sandpiper", "Red-breasted Nuthatch", "American Tree Sparrow", "Black-throated Green Warbler", "Northern Flicker", "Buff-breasted Flycatcher", "Red-necked Stint", "Eastern Phoebe", "Black-billed Cuckoo", "Mexican Whip-poor-will", "Sage Thrasher", "Least Flycatcher", "Chestnut-sided Warbler", "Chuck-will's-widow", "Grasshopper Sparrow", "Tricolored Blackbird", "Red Crossbill", "Spotted Owl", "Western Grebe", "American Robin", "Buff-bellied Hummingbird", "Violet-crowned Hummingbird", "Boreal Owl", "Grey-crowned Yellowthroat", "Blue Grosbeak", "Blue-headed Vireo", "Mourning Dove", "Horned Grebe", "Dunlin", "Marbled Godwit", "Bohemian Waxwing", "Mangrove Warbler", "Northern Tufted Flycatcher", "Flame-colored Tanager", "Mariana Crow", "Grey Vireo", "Golden-winged Warbler", "Great Kiskadee", "Tristram's Storm Petrel", "Pectoral Sandpiper", "Black-capped Vireo", "Mountain Quail", "Kauai Amakihi", "Baird's Sparrow", "Rose-breasted Grosbeak", "Yellow-bellied Flycatcher", "Northern Wheatear", "Downy Woodpecker", "Red-crested Cardinal", "Nutting's Flycatcher", "Laysan Albatross", "Eurasian Collared Dove", "Common Starling", "Sprague's Pipit", "Band-tailed Pigeon", "Ruby-crowned Kinglet", "Marsh Wren", "Barred Owl", "Painted Whitestart", "Pinyon Jay", "Lesser Prairie Chicken", "Hairy Woodpecker", "Surfbird", "Blackburnian Warbler", "Worm-eating Warbler", "Yellow-breasted Chat", "", "Greater Roadrunner", "Least Tern", "Western Sandpiper", "Mexican Chickadee", "Red-headed Woodpecker", "Bell's Vireo", "Grace's Warbler", "California Scrub Jay", "Cassin's Vireo", "Pine Grosbeak", "Painted Bunting", "Hawaii Elepaio", "Common Yellowthroat", "American Woodcock", "Black-throated Grey Warbler", "Red-vented Bulbul", "Rufous Hummingbird", "Japanese White-eye", "Hermit Warbler", "Red-necked Grebe", "Spot-breasted Oriole", "Clay-colored Sparrow", "Smith's Longspur", "Nelson's Sparrow", "Broad-tailed Hummingbird", "Common Waxbill", "Western Screech Owl", "Common Loon", "Lesser Goldfinch", "Swainson's Warbler", "Bluethroat", "Brown-crested Flycatcher", "Japanese Bush Warbler", "Carolina Chickadee", "Dusky-capped Flycatcher", "Chukar Partridge", "White-eyed Vireo", "Golden-fronted Woodpecker", "Tennessee Warbler", "Thick-billed Kingbird", "Dickcissel", "Yellow-eyed Junco", "Nashville Warbler", "Piping Plover", "Yellow-headed Blackbird", "Broad-winged Hawk", "Hepatic Tanager", "African Collared Dove", "American Dusky Flycatcher", "Oahu Amakihi", "Mountain Pygmy Owl", "Common Nighthawk", "Pied-billed Grebe", "Western Kingbird", "Zebra Dove", "Magnificent Hummingbird", "Wilson's Warbler", "Micronesian Myzomela", "Polynesian Starling", "Greater Prairie Chicken", "Maui Parrotbill", "Red-winged Blackbird", "Virginia's Warbler", "Whiskered Screech Owl", "Bell's Sparrow", "Plain Chachalaca", "Savannah Sparrow", "Great Crested Flycatcher", "Rock Sandpiper", "Cave Swallow", "Glaucous Gull", "Northern Shrike", "Pacific-slope Flycatcher", "Black-chinned Sparrow", "Rufous-winged Sparrow", "Willow Flycatcher", "Two-barred Crossbill", "Red-naped Sapsucker", "Buff-bellied Pipit", "Franklin's Gull", "White-throated Swift", "Identity unknown", "Upland Sandpiper", "Verdin", "Great Frigatebird", "Common Poorwill", "Mountain Chickadee", "Great-tailed Grackle", "Streak-backed Oriole", "Mariana Fruit Dove", "Say's Phoebe", "Black-crowned Night Heron", "White-throated Sparrow", "Elegant Trogon", "Willow Ptarmigan", "Willet", "Mountain Plover", "Stilt Sandpiper", "Scott's Oriole", "Brown Creeper", "Black Francolin", "Prairie Warbler", "Tropical Parula", "Kirtland's Warbler", "Sedge Wren", "Sagebrush Sparrow", "Bachman's Sparrow", "Long-tailed Duck", "Clark's Grebe", "Vermilion Flycatcher", "Pigeon Guillemot", "Ring-billed Gull", "Carolina Wren", "Eurasian Skylark", "Grey Jay", "White-crowned Sparrow", "Chilean Elaenia", "Pileated Woodpecker", "Orange-billed Nightingale-Thrush", "Bridled Titmouse", "Tropical Kingbird", "Chestnut-collared Longspur", "Blue-winged Warbler", "Steller's Jay", "Pacific Golden Plover", "Blue-grey Gnatcatcher", "Wilson's Plover", "Common Black Hawk", "Harris's Sparrow", "Rusty Blackbird", "Bronzed Cowbird", "Warbling Vireo", "Black-crested Titmouse", "Hawaii Amakihi", "Black Rail", "Bendire's Thrasher", "Cactus Wren", "Oahu Elepaio", "Cordilleran Flycatcher", "Black-footed Albatross", "Winter Wren", "Akepa", "Black-necked Stilt", "Saipan Reed Warbler", "Yellow-billed Loon", "Myrtle Warbler", "McKay's Bunting", "Bewick's Wren", "Brown-backed Solitaire", "Rock Ptarmigan", "Black-necked Grebe", "Indigo Bunting", "Red Fox Sparrow", "Gila Woodpecker", "Canada Warbler", "Golden-crowned Kinglet", "LeConte's Thrasher", "Red Knot", "Vaux's Swift", "Scarlet Tanager", "Red-cockaded Woodpecker", "Slate-throated Whitestart", "Cassin's Finch", "Mountain Bluebird", "Sharp-tailed Grouse", "Black-billed Magpie", "Northwestern Crow", "Black-capped Gnatcatcher", "Black-capped Chickadee", "Pacific Imperial Pigeon", "Red-faced Warbler", "Cerulean Warbler", "Wild Turkey", "Grey Kingbird", "Cape May Warbler", "Cassin's Sparrow", "Spotted Towhee", "Ferruginous Pygmy Owl", "Lark Sparrow", "Fiji Shrikebill", "Song Sparrow", "Antillean Nighthawk", "Common Gallinule", "Hawaiian Duck", "Yellow-green Vireo", "Snowy Plover", "White-breasted Nuthatch", "Wrentit", "McCown's Longspur", "Rufous-crowned Sparrow", "Gambel's Quail", "Anianiau", "Black Phoebe", "Grey-cheeked Thrush", "Northern Beardless Tyrannulet", "Field Sparrow"};
*/
    public static String bird2List[] = //SoundPack: Random Sounds
            {"Northern Saw-whet Owl", "Philadelphia Vireo", "Seaside Sparrow", "Canvasback"};






    //Re-add this in when the files are uploaded in the future
  /*  public int bird1FileNames[] =
            {R.raw.00300aegoliusacadicus477110, R.raw.00400vireophiladelphicus474833, R.raw.00592ammodramusmaritimus487417, R.raw.00638aythyavalisineria371522, R.raw.00767poecilerufescens420593, R.raw.00793passerinaversicolor252856, R.raw.00914botauruslentiginosus451067, R.raw.00917calcariuslapponicus420217, R.raw.01183chordeilesacutipennis109164, R.raw.01356dryobatesnuttallii408009, R.raw.01774setophagacitrina478573, R.raw.02003colinusvirginianus413574, R.raw.02044lampornisclemenciae345565, R.raw.02243leiothlypiscrissalis383125, R.raw.02362mergusserrator141724, R.raw.02520pluvialisdominica323107, R.raw.02599myiarchuscinerascens433791, R.raw.02985dumetellacarolinensis469539, R.raw.03529amphispizaquinquestriata435744, R.raw.03659empidonaxwrightii385803, R.raw.03671setophagacastanea480710, R.raw.03788pirangaludoviciana441369, R.raw.04210sporophilamorelleti147507, R.raw.04290myadestesobscurus385391, R.raw.04399icterusgalbula444946, R.raw.04968melospizageorgiana475100, R.raw.06545limosalapponica135141, R.raw.06559corvusbrachyrhynchos481136, R.raw.06784polioptilamelanura475184, R.raw.06883tringamelanoleuca408113, R.raw.06913psaltriparusminimus215758, R.raw.07018contopuspertinax380637, R.raw.07123psiloscopsflammeolus428231, R.raw.07533cardinalissinuatus474136, R.raw.07622geothlypisformosa478512, R.raw.07925drepaniscoccinea453296, R.raw.08311spinustristis462056, R.raw.08624icterusspurius487505, R.raw.08688selasphorussasin125251, R.raw.08897pluvialissquatarola316265, R.raw.09306baeolophusbicolor375653, R.raw.09317motacillatschutschensis141709, R.raw.09407cyanocoraxluxuosus155030, R.raw.09437myiodynastesluteiventris269311, R.raw.09502porzanacarolina418912, R.raw.09648loxopscaeruleirostris219961, R.raw.09697mniotiltavaria478569, R.raw.09723sternaforsteri406598, R.raw.09737myiopsittamonachus316273, R.raw.09767ixoreusnaevius416081, R.raw.09899acridotherestristis208162, R.raw.10158accipitercooperii11627, R.raw.10370melospizalincolnii488460, R.raw.10530micrathenewhitneyi363557, R.raw.10815coccyzusminor315493, R.raw.10857setophagachrysoparia317249, R.raw.10905numeniusamericanus347639, R.raw.11131setophagastriata488509, R.raw.11170pycnonotusjocosus131477, R.raw.11214acrocephalusfamiliaris144819, R.raw.11312catharusfuscescens425801, R.raw.11373aramusguarauna331321, R.raw.11593bubovirginianus442353, R.raw.12112melanittaamericana69921, R.raw.12217hylocichlamustelina486244, R.raw.12425centrocercusminimus75075, R.raw.12518coccyzusamericanus100137, R.raw.12855setophagaamericana488523, R.raw.13451ixobrychusexilis143608, R.raw.13508vireoflavifrons477608, R.raw.14261contopuscooperi443464, R.raw.14349stelgidopteryxserripennis420314, R.raw.14352calidrisbairdii185621, R.raw.14423juncohyemalis483708, R.raw.14969cypseloidesniger14997, R.raw.15042amaziliaberyllina145961, R.raw.15060toxostomalongirostre176252, R.raw.15555melozoneaberti247614, R.raw.15633tringaflavipes356449, R.raw.16031brantacanadensis418340, R.raw.16197leptotilaverreauxi277692, R.raw.16247toxostomacrissale468925, R.raw.16322sturnellaneglecta372033, R.raw.16601chasiempissclateri27337, R.raw.16747coturnicopsnoveboracensis469205, R.raw.17270empidonaxvirescens478572, R.raw.17865pipilochlorurus482213, R.raw.17869euphaguscyanocephalus377880, R.raw.18126icteruscucullatus484403, R.raw.18446parkesianoveboracensis380120, R.raw.18677hesperiphonavespertina476309, R.raw.18846nyctidromusalbicollis285306, R.raw.19141cynanthuslatirostris187631, R.raw.19242arremonopsrufivirgatus401312, R.raw.19595pheucticusmelanocephalus370065, R.raw.19603toxostomacurvirostre402949, R.raw.19849ammodramusleconteii282767, R.raw.20270crithagramozambica191213, R.raw.20324catherpesmexicanus461561, R.raw.20637sittapygmaea313506, R.raw.20927seiurusaurocapilla444964, R.raw.20940melanerpesformicivorus481135, R.raw.21071phylloscopusborealis421943, R.raw.21120tachycinetathalassina261347, R.raw.21242aythyaaffinis347797, R.raw.21378centrocercusurophasianus368675, R.raw.21694pipiloerythrophthalmus444954, R.raw.21839tyrannusforficatus323788, R.raw.22066zenaidaasiatica233404, R.raw.22068tyrannustyrannus323774, R.raw.22170falcipenniscanadensis269222, R.raw.22322chaeturapelagica487256, R.raw.22328calidrispusilla424198, R.raw.22337dendragapusobscurus361839, R.raw.22507crotophagasulcirostris299108, R.raw.22794calidrisalba406416, R.raw.22854callipeplacalifornica481114, R.raw.23069aphelocomainsularis27719, R.raw.23123myzomelacardinalis317190, R.raw.23183icterusgraduacauda358991, R.raw.23229megascopsasio478062, R.raw.23331hemignathuswilsoni306424, R.raw.23344vireoaltiloquus197264, R.raw.23786empidonaxalnorum479504, R.raw.24072haemorhouspurpureus486249, R.raw.24362motacillaalba103189, R.raw.24737hirundorustica481190, R.raw.24886aphelocomawollweberi165770, R.raw.24925phainopeplanitens465654, R.raw.24988perdixperdix189205, R.raw.25152basileuterusrufifrons279157, R.raw.25472picoidesdorsalis353490, R.raw.25525setophagadominica411428, R.raw.25526petrochelidonpyrrhonota468931, R.raw.25660passerellaunalaschcensis416076, R.raw.25693passerellamegarhyncha445160, R.raw.25804ammodramuscaudacutus433079, R.raw.26049icterusgularis306097, R.raw.26145tyrannuscouchii404720, R.raw.26315aphelocomacoerulescens316286, R.raw.26316gallinagodelicata469574, R.raw.26339setophagapalmarum410779, R.raw.27287tachycinetabicolor354703, R.raw.27763melanerpescarolinus343930, R.raw.28224zosteropsrotensis113740, R.raw.28344passerdomesticus485516, R.raw.28589ammodramushenslowii475142, R.raw.28640corvuscorax213233, R.raw.28826athenecunicularia382876, R.raw.29097butoridesvirescens469642, R.raw.29121cardinaliscardinalis234663, R.raw.29227acanthishornemanni142566, R.raw.29326pyrocephalusobscurus466755, R.raw.29341callipeplasquamata435473, R.raw.29586toxostomaredivivum444658, R.raw.30086dryobatesscalaris196553, R.raw.30193anascarolinensis459927, R.raw.30549selasphoruscalliope412986, R.raw.30737melozonefusca323280, R.raw.31256porphyriomartinica1147, R.raw.31274setophagamagnolia484389, R.raw.31845buteolineatus105723, R.raw.32161antrostomusridgwayi377681, R.raw.32334tachybaptusdominicus161321, R.raw.32386patagioenasleucocephala145946, R.raw.32671quiscalusquiscula371524, R.raw.32925leiothlypisluciae474141, R.raw.33008myadestestownsendi488461, R.raw.33115peucaeabotterii419050, R.raw.33143actitismacularius444487, R.raw.33192palmeriadolei122342, R.raw.33338geothlypisphiladelphia448187, R.raw.33345spatulaclypeata368726, R.raw.33645spizellabreweri483211, R.raw.33742colapteschrysoides382603, R.raw.33885pandionhaliaetus369949, R.raw.33959turdusgrayi277329, R.raw.34045thryophilussinaloa279006, R.raw.34166ralluselegans358056, R.raw.34275molothrusbonariensis365177, R.raw.34402loxioidesbailleui146104, R.raw.34857patagioenasflavirostris276871, R.raw.34906oxyurajamaicensis109911, R.raw.35636sphyrapicusruber408661, R.raw.35893molothrusater482295, R.raw.36241cyanocittacristata382356, R.raw.36341columbinapasserina414024, R.raw.36588marecapenelope41859, R.raw.36674baeolophusridgwayi394807, R.raw.36686phalaropusfulicarius406388, R.raw.36728charadriusvociferus408273, R.raw.36886gaviapacifica406246, R.raw.37037oporornisagilis480915, R.raw.37091dolichonyxoryzivorus477784, R.raw.37215calamospizamelanocorys263143, R.raw.37500leucosticteatrata143749, R.raw.37789phasianuscolchicus179662, R.raw.37898setophagaruticilla478575, R.raw.38162spinuslawrencei483003, R.raw.38239asiootus233963, R.raw.38286toxostomarufum483033, R.raw.38559spilopeliachinensis205837, R.raw.38632himationesanguinea454885, R.raw.38686strixnebulosa483006, R.raw.38692leiothlypiscelata482871, R.raw.38776calypteanna473411, R.raw.39003sonusnaturalis475622, R.raw.39109catharusbicknelli469601, R.raw.39308ralluscrepitans64539, R.raw.39399loxopsmana175502, R.raw.39456buteoplagiatus278723, R.raw.39563somateriaspectabilis141727, R.raw.39665vireoplumbeus483015, R.raw.39813sialiamexicana172425, R.raw.39856corvusossifragus432883, R.raw.39894troglodytesaedon440012, R.raw.40078protonotariacitrea478658, R.raw.40376aphelocomawoodhouseii215457, R.raw.40528setophagatownsendi475113, R.raw.40537calyptecostae203734, R.raw.40602dendragapusfuliginosus414091, R.raw.40714archilochusalexandri104902, R.raw.40935gaviastellata177221, R.raw.41025prognesubis480707, R.raw.41098antrostomusvociferus436196, R.raw.41284myadestespalmeri144892, R.raw.41285columbalivia485507, R.raw.42226baeolophusinornatus481143, R.raw.42247glaucidiumcalifornicum409946, R.raw.42291contopusvirens465082, R.raw.42431tringasolitaria406668, R.raw.42432leucophaeusatricilla1154, R.raw.42438laruscalifornicus125272, R.raw.42484peucedramustaeniatus410934, R.raw.42708sturnellamagna454687, R.raw.43340columbinainca360998, R.raw.43400zonotrichiaatricapilla481153, R.raw.43405setophagapinus476138, R.raw.43533foulehaiocarunculatus180849, R.raw.43571antigonecanadensis316293, R.raw.43682sittapusilla316289, R.raw.43749plectrophenaxnivalis416067, R.raw.44063limnodromusscolopaceus452766, R.raw.44112pirangarubra466198, R.raw.44169haemorhousmexicanus440009, R.raw.44265sialiasialis481623, R.raw.44280parabuteounicinctus1325, R.raw.44422pavocristatus452046, R.raw.44497buteojamaicensis1140, R.raw.44573passerinaamoena483011, R.raw.44585mimuspolyglottos470300, R.raw.44604megacerylealcyon368940, R.raw.44811contopussordidulus422905, R.raw.44902numeniustahitiensis406101, R.raw.45097salpinctesobsoletus451709, R.raw.45266telespizaultima144829, R.raw.45370vireoolivaceus486531, R.raw.45375eremophilaalpestris482274, R.raw.45510empidonaxhammondii424050, R.raw.45553tetraogallushimalayensis255349, R.raw.45558tyrannusvociferans392999, R.raw.45561catharusustulatus441361, R.raw.45603cyrtonyxmontezumae367668, R.raw.45604amphispizabilineata484906, R.raw.45614nucifragacolumbiana391598, R.raw.45910cinclusmexicanus400124, R.raw.46651vireohuttoni405621, R.raw.46776setophagaaestiva465395, R.raw.47047acanthisflammea141708, R.raw.47265pooecetesgramineus482289, R.raw.47387numeniusphaeopus356265, R.raw.47764laniusludovicianus297969, R.raw.47769parkesiamotacilla474097, R.raw.47934surniaulula67157, R.raw.48031lagopusleucura438516, R.raw.48195limnodromusgriseus460724, R.raw.48243charadriussemipalmatus323096, R.raw.48501troglodytespacificus482845, R.raw.48705passerellaschistacea369904, R.raw.48771catharusguttatus487926, R.raw.48882cygnuscolumbianus406440, R.raw.49019ralluslimicola359349, R.raw.49500empidonaxaffinis325674, R.raw.49620bombycillacedrorum476658, R.raw.49818setophagaauduboni103111, R.raw.49920spinuspinus349759, R.raw.50168melozonecrissalis477168, R.raw.50555poecilehudsonicus322979, R.raw.50679anasplatyrhynchos357023, R.raw.50917aplonisatrifusca314958, R.raw.51227setophagacaerulescens487497, R.raw.51628calidrismaritima452313, R.raw.51694recurvirostraamericana1150, R.raw.51768icterusbullockii367271, R.raw.51838passermontanus210878, R.raw.51858quiscalusmajor387127, R.raw.52030ardeaherodias419194, R.raw.52103spizellapasserina483740, R.raw.52356lophodytescucullatus90146, R.raw.52594geothlypistolmiei483002, R.raw.52670calidrisminutilla322794, R.raw.52712sittacanadensis461299, R.raw.52831spizelloidesarborea356271, R.raw.52898setophagavirens380129, R.raw.52941colaptesauratus444653, R.raw.53107empidonaxfulvifrons324275, R.raw.53711calidrisruficollis182179, R.raw.54015sayornisphoebe323217, R.raw.54110coccyzuserythropthalmus241134, R.raw.54349antrostomusarizonae253148, R.raw.54350oreoscoptesmontanus320563, R.raw.54386empidonaxminimus489102, R.raw.54807setophagapensylvanica444951, R.raw.55028antrostomuscarolinensis383108, R.raw.55066ammodramussavannarum480706, R.raw.55164agelaiustricolor393990, R.raw.55273loxiacurvirostra488680, R.raw.55299strixoccidentalis239658, R.raw.55346aechmophorusoccidentalis205821, R.raw.55353turdusmigratorius480065, R.raw.55413amaziliayucatanensis302265, R.raw.55483amaziliavioliceps71377, R.raw.55587aegoliusfunereus407879, R.raw.55627geothlypispoliocephala5640, R.raw.55691passerinacaerulea418911, R.raw.56259vireosolitarius486055, R.raw.56499zenaidamacroura382741, R.raw.57392podicepsauritus345549, R.raw.57615calidrisalpina323109, R.raw.57726limosafedoa163166, R.raw.57761bombycillagarrulus450556, R.raw.57765setophagapetechia307530, R.raw.57980mitrephanesphaeocercus380643, R.raw.58131pirangabidentata329709, R.raw.58613corvuskubaryi254699, R.raw.58708vireovicinior481046, R.raw.59174vermivorachrysoptera445079, R.raw.59321pitangussulphuratus440256, R.raw.59480oceanodromatristrami441709, R.raw.59586calidrismelanotos426277, R.raw.59832vireoatricapilla477409, R.raw.60115oreortyxpictus408812, R.raw.60126chlorodrepanisstejnegeri210213, R.raw.60284ammodramusbairdii335553, R.raw.60591pheucticusludovicianus479490, R.raw.60809empidonaxflaviventris187564, R.raw.60903oenantheoenanthe420221, R.raw.61005dryobatespubescens89855, R.raw.61417paroariacoronata314703, R.raw.61665myiarchusnuttingi252883, R.raw.61668phoebastriaimmutabilis164431, R.raw.61712streptopeliadecaocto481134, R.raw.61960sturnusvulgaris423323, R.raw.62080anthusspragueii355077, R.raw.62097patagioenasfasciata303691, R.raw.62202reguluscalendula322942, R.raw.62273cistothoruspalustris481193, R.raw.63142strixvaria433223, R.raw.63876myioboruspictus488517, R.raw.63897gymnorhinuscyanocephalus378149, R.raw.64046tympanuchuspallidicinctus216647, R.raw.64255leuconotopicusvillosus325121, R.raw.64718calidrisvirgata243979, R.raw.64802setophagafusca489097, R.raw.64810helmitherosvermivorum460696, R.raw.65189icteriavirens484785, R.raw.65192pterodromahypoleuca135835, R.raw.65205geococcyxcalifornianus463262, R.raw.65283sternulaantillarum130763, R.raw.65423calidrismauri149251, R.raw.65647poecilesclateri317973, R.raw.65707melanerpeserythrocephalus135670, R.raw.65873vireobellii277055, R.raw.65903setophagagraciae478205, R.raw.66015aphelocomacalifornica454467, R.raw.66179vireocassinii483027, R.raw.66510pinicolaenucleator369903, R.raw.66861passerinaciris277613, R.raw.67126chasiempissandwichensis175246, R.raw.67247geothlypistrichas444952, R.raw.67310scolopaxminor464355, R.raw.67391setophaganigrescens436811, R.raw.67394pycnonotuscafer454892, R.raw.67488selasphorusrufus174754, R.raw.67702zosteropsjaponicus175490, R.raw.68095setophagaoccidentalis436827, R.raw.68309podicepsgrisegena354608, R.raw.68886icteruspectoralis263052, R.raw.68898spizellapallida419201, R.raw.68931calcariuspictus356214, R.raw.68988ammodramusnelsoni445085, R.raw.69157selasphorusplatycercus374078, R.raw.69292estrildaastrild368429, R.raw.69778megascopskennicottii414263, R.raw.69927gaviaimmer457431, R.raw.70002spinuspsaltria288470, R.raw.70435limnothlypisswainsonii478780, R.raw.70646lusciniasvecica416336, R.raw.70981myiarchustyrannulus380720, R.raw.70993horornisdiphone27362, R.raw.71457poecilecarolinensis481972, R.raw.71593myiarchustuberculifer315696, R.raw.71617alectorischukar269241, R.raw.71798vireogriseus478579, R.raw.72132melanerpesaurifrons100142, R.raw.72407leiothlypisperegrina480715, R.raw.72493tyrannuscrassirostris238607, R.raw.72845spizaamericana444078, R.raw.73170juncophaeonotus488668, R.raw.73246leiothlypisruficapilla428341, R.raw.73523charadriusmelodus369941, R.raw.73890xanthocephalusxanthocephalus411393, R.raw.73944buteoplatypterus479508, R.raw.74272pirangahepatica373062, R.raw.74957streptopeliaroseogrisea375491, R.raw.74972empidonaxoberholseri385778, R.raw.75071chlorodrepanisflava454888, R.raw.75431glaucidiumgnoma283089, R.raw.75774chordeilesminor370484, R.raw.75973podilymbuspodiceps459166, R.raw.75977tyrannusverticalis443467, R.raw.76472geopeliastriata328022, R.raw.76618eugenesfulgens324508, R.raw.76883cardellinapusilla482705, R.raw.77311myzomelarubratra403089, R.raw.77798aplonistabuensis180842, R.raw.77850tympanuchuscupido468245, R.raw.77912pseudonestorxanthophrys123887, R.raw.78111agelaiusphoeniceus482986, R.raw.78211leiothlypisvirginiae422902, R.raw.78556megascopstrichopsis391565, R.raw.78565artemisiospizabelli413132, R.raw.78607ortalisvetula147484, R.raw.79104passerculussandwichensis354731, R.raw.79275myiarchuscrinitus481817, R.raw.79303calidrisptilocnemis406192, R.raw.79459petrochelidonfulva321333, R.raw.79636larushyperboreus406443, R.raw.80133laniusborealis91968, R.raw.80260empidonaxdifficilis483750, R.raw.80294spizellaatrogularis483157, R.raw.80381peucaeacarpalis489322, R.raw.80792empidonaxtraillii388445, R.raw.81045loxialeucoptera165652, R.raw.81444sphyrapicusnuchalis311849, R.raw.81497anthusrubescens277562, R.raw.81569leucophaeuspipixcan352969, R.raw.82411aeronautessaxatalis368921, R.raw.82488mysterymystery488157, R.raw.82532bartramialongicauda104331, R.raw.82776auriparusflaviceps316865, R.raw.82861fregataminor116571, R.raw.83058phalaenoptilusnuttallii461827, R.raw.83132poecilegambeli199595, R.raw.83163quiscalusmexicanus452996, R.raw.83180icteruspustulatus253181, R.raw.83262ptilinopusroseicapilla394600, R.raw.83377sayornissaya386336, R.raw.83791nycticoraxnycticorax152401, R.raw.83832zonotrichiaalbicollis467600, R.raw.83887trogonelegans345783, R.raw.83932lagopuslagopus410894, R.raw.84000tringasemipalmata444585, R.raw.84197charadriusmontanus131896, R.raw.84286calidrishimantopus203568, R.raw.84520icterusparisorum265054, R.raw.84610certhiaamericana482568, R.raw.84859francolinusfrancolinus175524, R.raw.85046setophagadiscolor478577, R.raw.85063setophagapitiayumi478448, R.raw.85117setophagakirtlandii467295, R.raw.85231cistothorusstellaris478450, R.raw.85256artemisiospizanevadensis462885, R.raw.85443peucaeaaestivalis414015, R.raw.86040clangulahyemalis406365, R.raw.86061aechmophorusclarkii367258, R.raw.86339pyrocephalusrubinus29069, R.raw.86512cepphuscolumba420374, R.raw.86632larusdelawarensis332148, R.raw.86651thryothorusludovicianus487506, R.raw.86873alaudaarvensis175235, R.raw.86887perisoreuscanadensis28872, R.raw.87160zonotrichialeucophrys328629, R.raw.87261elaeniachilensis392829, R.raw.87359dryocopuspileatus351542, R.raw.87397catharusaurantiirostris277476, R.raw.87539baeolophuswollweberi465416, R.raw.87959tyrannusmelancholicus383699, R.raw.88212calcariusornatus341859, R.raw.88379vermivoracyanoptera445083, R.raw.88645cyanocittastelleri461544, R.raw.88769pluvialisfulva420229, R.raw.88973polioptilacaerulea481964, R.raw.89264charadriuswilsonia239636, R.raw.89467buteogallusanthracinus80617, R.raw.89912zonotrichiaquerula70460, R.raw.90011euphaguscarolinus468246, R.raw.90037molothrusaeneus368475, R.raw.90119vireogilvus478702, R.raw.90309baeolophusatricristatus163949, R.raw.90321chlorodrepanisvirens27323, R.raw.90362laterallusjamaicensis419372, R.raw.90702toxostomabendirei409670, R.raw.90756campylorhynchusbrunneicapillus475569, R.raw.90785chasiempisibidis410155, R.raw.90896empidonaxoccidentalis422197, R.raw.91290phoebastrianigripes116357, R.raw.91434troglodyteshiemalis484393, R.raw.91640loxopscoccineus175511, R.raw.91715himantopusmexicanus1149, R.raw.91741acrocephalushiwae351544, R.raw.91923gaviaadamsii185362, R.raw.92200setophagacoronata475102, R.raw.92253plectrophenaxhyperboreus331841, R.raw.92270thryomanesbewickii484931, R.raw.92595myadestesoccidentalis37017, R.raw.92780lagopusmuta406103, R.raw.92919podicepsnigricollis323218, R.raw.92924passerinacyanea481963, R.raw.93039passerellailiaca461342, R.raw.93123melanerpesuropygialis408967, R.raw.93156cardellinacanadensis484391, R.raw.93358regulussatrapa484388, R.raw.93485toxostomalecontei469887, R.raw.93573calidriscanutus185586, R.raw.93965chaeturavauxi264029, R.raw.94041pirangaolivacea466880, R.raw.94211leuconotopicusborealis314693, R.raw.94476myioborusminiatus474206, R.raw.94496haemorhouscassinii436813, R.raw.94535sialiacurrucoides205426, R.raw.94659tympanuchusphasianellus368619, R.raw.94779picahudsonia15509, R.raw.94981corvuscaurinus420594, R.raw.95099polioptilanigriceps76315, R.raw.95229poecileatricapillus420409, R.raw.95302duculapacifica180841, R.raw.95341cardellinarubrifrons299339, R.raw.95606setophagacerulea479915, R.raw.95639meleagrisgallopavo465131, R.raw.95851tyrannusdominicensis196228, R.raw.95928setophagatigrina466992, R.raw.95971peucaeacassinii477195, R.raw.96197pipilomaculatus481125, R.raw.96484glaucidiumbrasilianum368470, R.raw.96678chondestesgrammacus423752, R.raw.96889clytorhynchusvitiensis181026, R.raw.97253melospizamelodia450245, R.raw.97456chordeilesgundlachii102918, R.raw.97736gallinulagaleata187977, R.raw.97826anaswyvilliana234981, R.raw.98102vireoflavoviridis481366, R.raw.98174charadriusnivosus419959, R.raw.98237sittacarolinensis475398, R.raw.98245chamaeafasciata312612, R.raw.98370rhynchophanesmccownii371869, R.raw.98846aimophilaruficeps426309, R.raw.98872callipeplagambelii487941, R.raw.98935magummaparva210206, R.raw.99549sayornisnigricans486800, R.raw.99729catharusminimus420272, R.raw.99734camptostomaimberbe367158, R.raw.99918spizellapusilla475033};
*/
//Note: all bird files total to over 800mb. consider splitting into parts


    Random r = new Random();
    //String myArray[] = getResources().getStringArray(R.array.ids);
    //tried to use the array in raw arrays.xml but it wouldn't convert
    int randomNumber = r.nextInt(list.length);
    static int i;
    static String i2;
    static int score;
    public static boolean gameOver;
    MediaPlayer mediaPlayer;
    public static int replayCounter = 4;

    protected void onStart() {





        if(cheatsActivated){
            replayCounter = 999999;
        }
        else {
            replayCounter = 4;
        }

        score = 0;
        super.onStart();

        Button buttonreplay = findViewById(R.id.buttonReplay);
        if(cheatsActivated){
            buttonreplay.setText("Replay (INFINITE! :)");
        }
        else{
            buttonreplay.setText("Replay x5");
        }

        //Keeps loop running

        gameOver = false;


        //Use loops to do this repeatedly


        int scoreKeeper;
        //Sets onClickListeners for each button
        Button buttonA = (Button) findViewById(R.id.buttonA);
        buttonA.setOnClickListener(this);
        Button buttonB = (Button) findViewById(R.id.buttonB);
        buttonB.setOnClickListener(this);
        Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(this);
        Button buttonD = (Button) findViewById(R.id.buttonD);
        buttonD.setOnClickListener(this);

        
       /* ArrayList<Integer> integerArrayList2 = new ArrayList<>();
        integerArrayList2.add(R.raw.doorknock);
        integerArrayList2.add(R.raw.heavyrain);
        integerArrayList2.add(R.raw.morsecode);
        integerArrayList2.add(R.raw.spaceship);
        Collections.shuffle(integerArrayList2); */




        Random r = new Random();
        //String myArray[] = getResources().getStringArray(R.array.ids);
        //tried to use the array in raw arrays.xml but it wouldn't convert
        int randomNumber = r.nextInt(arrayNameHolderBoi.length);
        int randomNumber2 = r.nextInt(arrayNameHolderBoi.length);
        int randomNumber3 = r.nextInt(arrayNameHolderBoi.length);
        int randomNumber4 = r.nextInt(arrayNameHolderBoi.length);

        while (randomNumber2 == randomNumber || randomNumber2 == randomNumber3 || randomNumber2 == randomNumber4) {
            randomNumber2 = r.nextInt(arrayNameHolderBoi.length);
        }


        while (randomNumber3 == randomNumber || randomNumber3 == randomNumber2 || randomNumber3 == randomNumber4) {
            randomNumber3 = r.nextInt(arrayNameHolderBoi.length);
        }

        while (randomNumber4 == randomNumber || randomNumber4 == randomNumber2 || randomNumber4 == randomNumber3) {
            randomNumber4 = r.nextInt(arrayNameHolderBoi.length);
        }

        i = arrayHolderBoi[randomNumber];
        int index = randomNumber;
        i2 =  arrayNameHolderBoi[index];


        /*
        Sample of Arrays.copyOf
        int[] testerBoi = {1,2,3,4,5};
        int[] testerBoiRecipient = Arrays.copyOf(testerBoi, testerBoi.length);
*/
        ArrayList<Button> arrayList = new ArrayList<>();
        arrayList.add(buttonA);
        arrayList.add(buttonB);
        arrayList.add(buttonC);
        arrayList.add(buttonD);
        Collections.shuffle(arrayList);
        //Chosen button A is the button used in the main activity, completley random
        Button chosenButtonA = arrayList.get(0);
        Button chosenButtonB = arrayList.get(1);
        Button chosenButtonC = arrayList.get(2);
        Button chosenButtonD = arrayList.get(3);


        /*
        When more btns are added in the future add them into the lists.
         */


        //Sets the button text


        chosenButtonA.setText(arrayNameHolderBoi[randomNumber]);
        chosenButtonB.setText(arrayNameHolderBoi[randomNumber2]);
        chosenButtonC.setText(arrayNameHolderBoi[randomNumber3]);
        chosenButtonD.setText(arrayNameHolderBoi[randomNumber4]);


        //Statements to decide if the button pressed is the correct button


        //Media Player Object

         //Might need to change this l8r
        mediaPlayer = MediaPlayer.create(this, i); //Placeholder file, change heavyrain to change what sound file it's playing
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(list[randomNumber]);
        mediaPlayer.start();


    }



    @Override
    public void onClick(View v){
            Button buttonA = (Button) findViewById(R.id.buttonA);
            buttonA.setOnClickListener(this);
            Button buttonB = (Button) findViewById(R.id.buttonB);
            buttonB.setOnClickListener(this);
            Button buttonC = (Button) findViewById(R.id.buttonC);
            buttonC.setOnClickListener(this);
            Button buttonD = (Button) findViewById(R.id.buttonD);
            buttonD.setOnClickListener(this);



            //Determine if button's been pressed or not
            switch (v.getId()) {

                case R.id.buttonA:
                    if (buttonA.getText() == i2 || cheatsActivated) {
                        score+=1;
                        TextView textView = findViewById(R.id.score);
                        textView.setText("Score: " + Integer.toString(score));

                        placeHolder();

                    } else {
                        Intent intent = new Intent(this, takeTheLuke.class);
                        startActivity(intent);
                        mediaPlayer.stop();
                        mediaPlayer.release();


                    }
                    break;

                case R.id.buttonB:
                    if (buttonB.getText() == i2 || cheatsActivated) {
                        score+=1;
                        TextView textView = findViewById(R.id.score);
                        textView.setText("Score: " + Integer.toString(score));

                        placeHolder();


                    } else {
                        Intent intent = new Intent(this, takeTheLuke.class);
                        startActivity(intent);
                        mediaPlayer.stop();
                        mediaPlayer.release();

                    }
                    break;

                case R.id.buttonC:
                    if (buttonC.getText() == i2 || cheatsActivated) {
                        score+=1;
                        TextView textView = findViewById(R.id.score);
                        textView.setText("Score: " + Integer.toString(score));

                        placeHolder();

                    } else {
                        Intent intent = new Intent(this, takeTheLuke.class);
                        startActivity(intent);
                        mediaPlayer.stop();
                        mediaPlayer.release();

                    }
                    break;
                case R.id.buttonD:
                    if (buttonD.getText() == i2 || cheatsActivated) {
                        score+=1;
                        TextView textView = findViewById(R.id.score);
                        textView.setText("Score: " + Integer.toString(score));

                        placeHolder();

                    } else {
                        Intent intent = new Intent(this, takeTheLuke.class);
                        startActivity(intent);
                        mediaPlayer.stop();
                        mediaPlayer.release();

                    }
                    break;
                default:
                    break;
            }

        }

    public void replayButton(View v){

        Button button = findViewById(R.id.buttonReplay);

        button.setText("Replay x" + replayCounter);
        if (cheatsActivated){
            button.setText("Replay x∞ :)");
            replayCounter = 9999;

        }
        if(replayCounter!=0){
            replayCounter-=1;
            playSound();
    }
    else{
            button.setText("No Replays Left :(");
        }
    }

    public void playSound() {
        mediaPlayer.stop();
        mediaPlayer.release();
        //Place music files in file called raw, then after that the name of the file
         mediaPlayer = MediaPlayer.create(this, i); //Placeholder file, change heavyrain to change what sound file it's playing
        mediaPlayer.start(); }

    public void placeHolder() { //Causes the app to function more than once
        mediaPlayer.stop();
        mediaPlayer.release();
        replayCounter = 4;



            int scoreKeeper;
            //Sets onClickListeners for each button
            Button buttonA = (Button) findViewById(R.id.buttonA);
            buttonA.setOnClickListener(this);
            Button buttonB = (Button) findViewById(R.id.buttonB);
            buttonB.setOnClickListener(this);
            Button buttonC = (Button) findViewById(R.id.buttonC);
            buttonC.setOnClickListener(this);
            Button buttonD = (Button) findViewById(R.id.buttonD);
            buttonD.setOnClickListener(this);


            Random r = new Random();
            //String myArray[] = getResources().getStringArray(R.array.ids);
            //tried to use the array in raw arrays.xml but it wouldn't convert
            int randomNumber = r.nextInt(arrayNameHolderBoi.length);
            int randomNumber2 = r.nextInt(arrayNameHolderBoi.length);
            int randomNumber3 = r.nextInt(arrayNameHolderBoi.length);
            int randomNumber4 = r.nextInt(arrayNameHolderBoi.length);

            while (randomNumber2 == randomNumber || randomNumber2 == randomNumber3 || randomNumber2 == randomNumber4) {
                randomNumber2 = r.nextInt(arrayNameHolderBoi.length);
            }


            while (randomNumber3 == randomNumber || randomNumber3 == randomNumber2 || randomNumber3 == randomNumber4) {
                randomNumber3 = r.nextInt(arrayNameHolderBoi.length);
            }

            while (randomNumber4 == randomNumber || randomNumber4 == randomNumber2 || randomNumber4 == randomNumber3) {
                randomNumber4 = r.nextInt(arrayNameHolderBoi.length);
            }
            i = arrayHolderBoi[randomNumber];
            int index = randomNumber;
            i2 = arrayNameHolderBoi[index];

            ArrayList<Button> arrayList = new ArrayList<>();
            arrayList.add(buttonA);
            arrayList.add(buttonB);
            arrayList.add(buttonC);
            arrayList.add(buttonD);
            Collections.shuffle(arrayList);
            //Chosen button A is the button used in the main activity, completley random
            Button chosenButtonA = arrayList.get(0);
            Button chosenButtonB = arrayList.get(1);
            Button chosenButtonC = arrayList.get(2);
            Button chosenButtonD = arrayList.get(3);

            chosenButtonA.setText(i2);
            chosenButtonB.setText(arrayNameHolderBoi[randomNumber2]);
            chosenButtonC.setText(arrayNameHolderBoi[randomNumber3]);
            chosenButtonD.setText(arrayNameHolderBoi[randomNumber4]);

            mediaPlayer = MediaPlayer.create(getBaseContext(), i); //Placeholder file, change heavyrain to change what sound file it's playing
            mediaPlayer.start();

        }



    public void onQuitPress(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure you want to quit?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                Html.fromHtml("<font color='#FF0000'>Exit this great app</font>"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        System.exit(0);
                        moveTaskToBack(true);
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                Html.fromHtml("<font color='#000000'>Stay here</font>"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "Thanks for staying!", Toast.LENGTH_SHORT).show();
                        dialog.cancel();

                    }
                });

        AlertDialog alert11 = builder1.create();

        alert11.show();

    }
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        mediaPlayer.release();
        Intent intent = new Intent(this, StartScreen.class);
        startActivity(intent);    }
}














