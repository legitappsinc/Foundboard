package com.eoenesapps.myapplication;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public int  list[]= //SoundPack: Random Sounds
            {R.raw.doorknock, R.raw.heavyrain, R.raw.morsecode, R.raw.spaceship};

    public String list2[] = //SoundPack: Random Sounds
            {"Door Knocking", "Heavy Rain", "Morse Code", "Spaceship"};

    public String bird1Names[] = //SoundPack: Random Sounds
            {"Northern Saw-whet Owl", "Philadelphia Vireo", "Seaside Sparrow", "Canvasback", "Chestnut-backed Chickadee", "Varied Bunting", "American Bittern", "Lapland Longspur", "Lesser Nighthawk", "Nuttall's Woodpecker", "Hooded Warbler", "Northern Bobwhite", "Blue-throated Mountaingem", "Colima Warbler", "Red-breasted Merganser", "American Golden Plover", "Ash-throated Flycatcher", "Grey Catbird", "Five-striped Sparrow", "American Grey Flycatcher", "Bay-breasted Warbler", "Western Tanager", "Morelet's Seedeater", "Omao", "Baltimore Oriole", "Swamp Sparrow", "Bar-tailed Godwit", "American Crow", "Black-tailed Gnatcatcher", "Greater Yellowlegs", "American Bushtit", "Greater Pewee", "Flammulated Owl", "Pyrrhuloxia", "Kentucky Warbler", "Iiwi", "American Goldfinch", "Orchard Oriole", "Allen's Hummingbird", "Grey Plover", "Tufted Titmouse", "Eastern Yellow Wagtail", "Green Jay", "Sulphur-bellied Flycatcher", "Sora", "Akekee", "Black-and-white Warbler", "Forster's Tern", "Monk Parakeet", "Varied Thrush", "Common Myna", "Cooper's Hawk", "Lincoln's Sparrow", "Elf Owl", "Mangrove Cuckoo", "Golden-cheeked Warbler", "Long-billed Curlew", "Blackpoll Warbler", "Red-whiskered Bulbul", "Millerbird", "Veery", "Limpkin", "Great Horned Owl", "Black Scoter", "Wood Thrush", "Gunnison Grouse", "Yellow-billed Cuckoo", "Northern Parula", "Least Bittern", "Yellow-throated Vireo", "Olive-sided Flycatcher", "Northern Rough-winged Swallow", "Baird's Sandpiper", "Dark-eyed Junco", "American Black Swift", "Berylline Hummingbird", "Long-billed Thrasher", "Abert's Towhee", "Lesser Yellowlegs", "Canada Goose", "White-tipped Dove", "Crissal Thrasher", "Western Meadowlark", "Kauai Elepaio", "Yellow Rail", "Acadian Flycatcher", "Green-tailed Towhee", "Brewer's Blackbird", "Hooded Oriole", "Northern Waterthrush", "Evening Grosbeak", "Pauraque", "Broad-billed Hummingbird", "Olive Sparrow", "Black-headed Grosbeak", "Curve-billed Thrasher", "Le Conte's Sparrow", "Yellow-fronted Canary", "Canyon Wren", "Pygmy Nuthatch", "Ovenbird", "Acorn Woodpecker", "Arctic Warbler", "Violet-green Swallow", "Lesser Scaup", "Sage Grouse", "Eastern Towhee", "Scissor-tailed Flycatcher", "White-winged Dove", "Eastern Kingbird", "Spruce Grouse", "Chimney Swift", "Semipalmated Sandpiper", "Dusky Grouse", "Groove-billed Ani", "Sanderling", "California Quail", "Island Scrub Jay", "Cardinal Myzomela", "Audubon's Oriole", "Eastern Screech Owl", "Akiapolaau", "Black-whiskered Vireo", "Alder Flycatcher", "Purple Finch", "White Wagtail", "Barn Swallow", "Mexican Jay", "Phainopepla", "Grey Partridge", "Rufous-capped Warbler", "American Three-toed Woodpecker", "Yellow-throated Warbler", "American Cliff Swallow", "Sooty Fox Sparrow", "Thick-billed Fox Sparrow", "Saltmarsh Sparrow", "Altamira Oriole", "Couch's Kingbird", "Florida Scrub Jay", "Wilson's Snipe", "Palm Warbler", "Tree Swallow", "Red-bellied Woodpecker", "Rota White-eye", "House Sparrow", "Henslow's Sparrow", "Northern Raven", "Burrowing Owl", "Green Heron", "Northern Cardinal", "Arctic Redpoll", "Vermilion Flycatcher", "Scaled Quail", "California Thrasher", "Ladder-backed Woodpecker", "Green-winged Teal", "Calliope Hummingbird", "Canyon Towhee", "Purple Gallinule", "Magnolia Warbler", "Red-shouldered Hawk", "Buff-collared Nightjar", "Least Grebe", "White-crowned Pigeon", "Common Grackle", "Lucy's Warbler", "Townsend's Solitaire", "Botteri's Sparrow", "Spotted Sandpiper", "Akohekohe", "Mourning Warbler", "Northern Shoveler", "Brewer's Sparrow", "Gilded Flicker", "Western Osprey", "Clay-colored Thrush", "Sinaloa Wren", "King Rail", "Shiny Cowbird", "Palila", "Red-billed Pigeon", "Ruddy Duck", "Red-breasted Sapsucker", "Brown-headed Cowbird", "Blue Jay", "Common Ground Dove", "Eurasian Wigeon", "Juniper Titmouse", "Red Phalarope", "Killdeer", "Pacific Loon", "Connecticut Warbler", "Bobolink", "Lark Bunting", "Black Rosy Finch", "Common Pheasant", "American Redstart", "Lawrence's Goldfinch", "Long-eared Owl", "Brown Thrasher", "Spotted Dove", "Apapane", "Great Grey Owl", "Orange-crowned Warbler", "Anna's Hummingbird", "Soundscape", "Bicknell's Thrush", "Clapper Rail", "Hawaii Creeper", "Grey Hawk", "King Eider", "Plumbeous Vireo", "Western Bluebird", "Fish Crow", "House Wren", "Prothonotary Warbler", "Woodhouse's Scrub Jay", "Townsend's Warbler", "Costa's Hummingbird", "Sooty Grouse", "Black-chinned Hummingbird", "Red-throated Loon", "Purple Martin", "Eastern Whip-poor-will", "Puaiohi", "Rock Dove", "Oak Titmouse", "Northern Pygmy Owl", "Eastern Wood Pewee", "Solitary Sandpiper", "Laughing Gull", "California Gull", "Olive Warbler", "Eastern Meadowlark", "Inca Dove", "Golden-crowned Sparrow", "Pine Warbler", "Wattled Honeyeater", "Sandhill Crane", "Brown-headed Nuthatch", "Snow Bunting", "Long-billed Dowitcher", "Summer Tanager", "House Finch", "Eastern Bluebird", "Harris's Hawk", "Indian Peafowl", "Red-tailed Hawk", "Lazuli Bunting", "Northern Mockingbird", "Belted Kingfisher", "Western Wood Pewee", "Bristle-thighed Curlew", "Rock Wren", "Nihoa Finch", "Red-eyed Vireo", "Horned Lark", "Hammond's Flycatcher", "Himalayan Snowcock", "Cassin's Kingbird", "Swainson's Thrush", "Montezuma Quail", "Black-throated Sparrow", "Clark's Nutcracker", "American Dipper", "Hutton's Vireo", "American Yellow Warbler", "Common Redpoll", "Vesper Sparrow", "Whimbrel", "Loggerhead Shrike", "Louisiana Waterthrush", "Northern Hawk-Owl", "White-tailed Ptarmigan", "Short-billed Dowitcher", "Semipalmated Plover", "Pacific Wren", "Slate-colored Fox Sparrow", "Hermit Thrush", "Tundra Swan", "Virginia Rail", "Pine Flycatcher", "Cedar Waxwing", "Audubon's Warbler", "Pine Siskin", "California Towhee", "Boreal Chickadee", "Mallard", "Samoan Starling", "Black-throated Blue Warbler", "Purple Sandpiper", "American Avocet", "Bullock's Oriole", "Eurasian Tree Sparrow", "Boat-tailed Grackle", "Great Blue Heron", "Chipping Sparrow", "Hooded Merganser", "MacGillivray's Warbler", "Least Sandpiper", "Red-breasted Nuthatch", "American Tree Sparrow", "Black-throated Green Warbler", "Northern Flicker", "Buff-breasted Flycatcher", "Red-necked Stint", "Eastern Phoebe", "Black-billed Cuckoo", "Mexican Whip-poor-will", "Sage Thrasher", "Least Flycatcher", "Chestnut-sided Warbler", "Chuck-will's-widow", "Grasshopper Sparrow", "Tricolored Blackbird", "Red Crossbill", "Spotted Owl", "Western Grebe", "American Robin", "Buff-bellied Hummingbird", "Violet-crowned Hummingbird", "Boreal Owl", "Grey-crowned Yellowthroat", "Blue Grosbeak", "Blue-headed Vireo", "Mourning Dove", "Horned Grebe", "Dunlin", "Marbled Godwit", "Bohemian Waxwing", "Mangrove Warbler", "Northern Tufted Flycatcher", "Flame-colored Tanager", "Mariana Crow", "Grey Vireo", "Golden-winged Warbler", "Great Kiskadee", "Tristram's Storm Petrel", "Pectoral Sandpiper", "Black-capped Vireo", "Mountain Quail", "Kauai Amakihi", "Baird's Sparrow", "Rose-breasted Grosbeak", "Yellow-bellied Flycatcher", "Northern Wheatear", "Downy Woodpecker", "Red-crested Cardinal", "Nutting's Flycatcher", "Laysan Albatross", "Eurasian Collared Dove", "Common Starling", "Sprague's Pipit", "Band-tailed Pigeon", "Ruby-crowned Kinglet", "Marsh Wren", "Barred Owl", "Painted Whitestart", "Pinyon Jay", "Lesser Prairie Chicken", "Hairy Woodpecker", "Surfbird", "Blackburnian Warbler", "Worm-eating Warbler", "Yellow-breasted Chat", "", "Greater Roadrunner", "Least Tern", "Western Sandpiper", "Mexican Chickadee", "Red-headed Woodpecker", "Bell's Vireo", "Grace's Warbler", "California Scrub Jay", "Cassin's Vireo", "Pine Grosbeak", "Painted Bunting", "Hawaii Elepaio", "Common Yellowthroat", "American Woodcock", "Black-throated Grey Warbler", "Red-vented Bulbul", "Rufous Hummingbird", "Japanese White-eye", "Hermit Warbler", "Red-necked Grebe", "Spot-breasted Oriole", "Clay-colored Sparrow", "Smith's Longspur", "Nelson's Sparrow", "Broad-tailed Hummingbird", "Common Waxbill", "Western Screech Owl", "Common Loon", "Lesser Goldfinch", "Swainson's Warbler", "Bluethroat", "Brown-crested Flycatcher", "Japanese Bush Warbler", "Carolina Chickadee", "Dusky-capped Flycatcher", "Chukar Partridge", "White-eyed Vireo", "Golden-fronted Woodpecker", "Tennessee Warbler", "Thick-billed Kingbird", "Dickcissel", "Yellow-eyed Junco", "Nashville Warbler", "Piping Plover", "Yellow-headed Blackbird", "Broad-winged Hawk", "Hepatic Tanager", "African Collared Dove", "American Dusky Flycatcher", "Oahu Amakihi", "Mountain Pygmy Owl", "Common Nighthawk", "Pied-billed Grebe", "Western Kingbird", "Zebra Dove", "Magnificent Hummingbird", "Wilson's Warbler", "Micronesian Myzomela", "Polynesian Starling", "Greater Prairie Chicken", "Maui Parrotbill", "Red-winged Blackbird", "Virginia's Warbler", "Whiskered Screech Owl", "Bell's Sparrow", "Plain Chachalaca", "Savannah Sparrow", "Great Crested Flycatcher", "Rock Sandpiper", "Cave Swallow", "Glaucous Gull", "Northern Shrike", "Pacific-slope Flycatcher", "Black-chinned Sparrow", "Rufous-winged Sparrow", "Willow Flycatcher", "Two-barred Crossbill", "Red-naped Sapsucker", "Buff-bellied Pipit", "Franklin's Gull", "White-throated Swift", "Identity unknown", "Upland Sandpiper", "Verdin", "Great Frigatebird", "Common Poorwill", "Mountain Chickadee", "Great-tailed Grackle", "Streak-backed Oriole", "Mariana Fruit Dove", "Say's Phoebe", "Black-crowned Night Heron", "White-throated Sparrow", "Elegant Trogon", "Willow Ptarmigan", "Willet", "Mountain Plover", "Stilt Sandpiper", "Scott's Oriole", "Brown Creeper", "Black Francolin", "Prairie Warbler", "Tropical Parula", "Kirtland's Warbler", "Sedge Wren", "Sagebrush Sparrow", "Bachman's Sparrow", "Long-tailed Duck", "Clark's Grebe", "Vermilion Flycatcher", "Pigeon Guillemot", "Ring-billed Gull", "Carolina Wren", "Eurasian Skylark", "Grey Jay", "White-crowned Sparrow", "Chilean Elaenia", "Pileated Woodpecker", "Orange-billed Nightingale-Thrush", "Bridled Titmouse", "Tropical Kingbird", "Chestnut-collared Longspur", "Blue-winged Warbler", "Steller's Jay", "Pacific Golden Plover", "Blue-grey Gnatcatcher", "Wilson's Plover", "Common Black Hawk", "Harris's Sparrow", "Rusty Blackbird", "Bronzed Cowbird", "Warbling Vireo", "Black-crested Titmouse", "Hawaii Amakihi", "Black Rail", "Bendire's Thrasher", "Cactus Wren", "Oahu Elepaio", "Cordilleran Flycatcher", "Black-footed Albatross", "Winter Wren", "Akepa", "Black-necked Stilt", "Saipan Reed Warbler", "Yellow-billed Loon", "Myrtle Warbler", "McKay's Bunting", "Bewick's Wren", "Brown-backed Solitaire", "Rock Ptarmigan", "Black-necked Grebe", "Indigo Bunting", "Red Fox Sparrow", "Gila Woodpecker", "Canada Warbler", "Golden-crowned Kinglet", "LeConte's Thrasher", "Red Knot", "Vaux's Swift", "Scarlet Tanager", "Red-cockaded Woodpecker", "Slate-throated Whitestart", "Cassin's Finch", "Mountain Bluebird", "Sharp-tailed Grouse", "Black-billed Magpie", "Northwestern Crow", "Black-capped Gnatcatcher", "Black-capped Chickadee", "Pacific Imperial Pigeon", "Red-faced Warbler", "Cerulean Warbler", "Wild Turkey", "Grey Kingbird", "Cape May Warbler", "Cassin's Sparrow", "Spotted Towhee", "Ferruginous Pygmy Owl", "Lark Sparrow", "Fiji Shrikebill", "Song Sparrow", "Antillean Nighthawk", "Common Gallinule", "Hawaiian Duck", "Yellow-green Vireo", "Snowy Plover", "White-breasted Nuthatch", "Wrentit", "McCown's Longspur", "Rufous-crowned Sparrow", "Gambel's Quail", "Anianiau", "Black Phoebe", "Grey-cheeked Thrush", "Northern Beardless Tyrannulet", "Field Sparrow"};


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
    public boolean gameOver;
    MediaPlayer mediaPlayer;
    public static int replayCounter = 4;

    protected void onStart() {
        replayCounter=4;
        score = 0;
        super.onStart();

        Button buttonreplay = findViewById(R.id.buttonReplay);
        buttonreplay.setText("Replay x5");

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
        int randomNumber = r.nextInt(list2.length);
        int randomNumber2 = r.nextInt(list2.length);
        int randomNumber3 = r.nextInt(list2.length);
        int randomNumber4 = r.nextInt(list2.length);

        while (randomNumber2 == randomNumber || randomNumber2 == randomNumber3 || randomNumber2 == randomNumber4) {
            randomNumber2 = r.nextInt(list2.length);
        }


        while (randomNumber3 == randomNumber || randomNumber3 == randomNumber2 || randomNumber3 == randomNumber4) {
            randomNumber3 = r.nextInt(list2.length);
        }

        while (randomNumber4 == randomNumber || randomNumber4 == randomNumber2 || randomNumber4 == randomNumber3) {
            randomNumber4 = r.nextInt(list2.length);
        }

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


        chosenButtonA.setText(list2[randomNumber]);
        chosenButtonB.setText(list2[randomNumber2]);
        chosenButtonC.setText(list2[randomNumber3]);
        chosenButtonD.setText(list2[randomNumber4]);


        //Statements to decide if the button pressed is the correct button


        //Media Player Object

        i = list[randomNumber];
        i2 = list2[randomNumber];
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
                    if (buttonA.getText() == i2) {
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
                    if (buttonB.getText() == i2) {
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
                    if (buttonC.getText() == i2) {
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
                    if (buttonD.getText() == i2) {
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
        int randomNumber = r.nextInt(list2.length);
        int randomNumber2 = r.nextInt(list2.length);
        int randomNumber3 = r.nextInt(list2.length);
        int randomNumber4 = r.nextInt(list2.length);

        while (randomNumber2 == randomNumber || randomNumber2 == randomNumber3 || randomNumber2 == randomNumber4) {
            randomNumber2 = r.nextInt(list2.length);
        }


        while (randomNumber3 == randomNumber || randomNumber3 == randomNumber2 || randomNumber3 == randomNumber4) {
            randomNumber3 = r.nextInt(list2.length);
        }

        while (randomNumber4 == randomNumber || randomNumber4 == randomNumber2 || randomNumber4 == randomNumber3) {
            randomNumber4 = r.nextInt(list2.length);
        }

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

        chosenButtonA.setText(list2[randomNumber]);
        chosenButtonB.setText(list2[randomNumber2]);
        chosenButtonC.setText(list2[randomNumber3]);
        chosenButtonD.setText(list2[randomNumber4]);
        i = list[randomNumber];
        i2 = list2[randomNumber];
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

    }}













