// 3 types de users : ceux qui ont des sports et des places déjà,
// ou juste des places, ou rien. D'après notre logique, ils ne
// peuvent pas mettre de sports s'ils n'ont pas de places déjà

const users=[
    {id:1, firstName:'Michel', lastName:'Perucca', mail:'michel@perucca.fr', password:'Mich123!', isMyPlacesEmpty: true, isMySportsEmpty : true},
    {id:2, firstName:'Dorian', lastName:'Screm', mail:'dorian@screm.us' , password:'Dodo#456', isMyPlacesEmpty: false, isMySportsEmpty: true},
    {id:3, firstName:'Angélique', lastName:'Montuwy', mail:'angelique@montuwy.be', password:'AngelDu59', isMyPlacesEmpty: false, isMySportsEmpty: false},
    {id:4, firstName:'Jean-Michel', lastName:'Vedette', mail:'jm@vedette.com', password:'jmv789', isMyPlacesEmpty:false, isMySportsEmpty: false}
];

const sports=[
    {id:1, type:'EAU', name:'Kayak'},
    {id:2, type:'AIR', name:'Parapente'},
    {id:3, type:'EAU', name:'Voilier'},
    {id:4, type:'MECANIQUE', name:'Vélo'},
    {id:5, type:'AIR', name:'Cerf-Volant'},
    {id:6, type:'TERRE', name:'Chasse'},
    {id:7, type:'NEIGE', name:'Ski'},
    {id:8, type:'EAU', name:'Bronzette'},
    {id:9, type:'MECANIQUE', name:'Quad'}
];

const places=[
    {id:1, name:'Redon', postcode:'35600'},
    {id:2, name:'Vannes', postcode:'56000'},
    {id:3, name:'Nantes', postcode:'44000'},
    {id:4, name:'Saint Brieuc', postcode:'22000'},
    {id:5, name:'Caen', postcode:'14000'},
    {id:6, name:'Dunkerque', postcode:'59240'},
    {id:7, name:'Annecy', postcode:'74000'},
    {id:8, name:'Marseille', postcode:'13000'},
    {id:9, name:'Bains-sur-Oust', postcode:'35600'},
    {id:10, name:'Saint-Omer', postcode:'62500'},
    {id:11, name:'Saint-Omer', postcode:'44130'},
    {id:12, name:'Sainte-Marie-de-Redon', postcode:'35600'},
];

//user 2, 3 et 4 ont des userplaces définies
//NB : je rajoute l'id du user par rapport au DTO car là on en aura besoin pour piocher dans le tableau
const userplaces=[
    {id:1, userid:2, placeid:1, name:'Redon', postcode:'35600', pref:1.0},
    {id:2, userid:2, placeid:6, name:'Dunkerque', postcode:'59240', pref:3.0},
    {id:3, userid:2, placeid:2, name:'Vannes', postcode:'56000', pref:4.0},
    {id:4, userid:2, placeid:9, name:'Bains-sur-Oust', postcode:'35600', pref:2.0},
    {id:5, userid:3, placeid:7, name:'Annecy', postcode:'74000', pref:2.0},
    {id:6, userid:3, placeid:5, name:'Caen', postcode:'14000', pref:1.0},
    {id:7, userid:4, placeid:11, name:'Saint-Omer', postcode:'44130', pref:1.0},
    {id:8, userid:4, placeid:6, name:'Dunkerque', postcode:'59240', pref:2.0}
]

//user 3 et 4 ont des usersports définis et donc des sport-place association
const usersports=[
    {id:1, userid:3, sportid:1, type:'EAU', name:'Kayak', pref:3.0},
    {id:2, userid:3, sportid:4, type:'MECANIQUE', name:'Vélo', pref:1.0},
    {id:3, userid:3, sportid:6, type:'TERRE', name:'Chasse', pref:2.0},
    {id:4, userid:3, sportid:9, type:'MECANIQUE', name:'Quad', pref:4.0},
    {id:5, userid:3, sportid:5, type:'AIR', name:'Cerf-Volant', pref:5.0},
    {id:6, userid:4, sportid:3, type:'EAU', name:'Voilier', pref:4.0},
    {id:7, userid:4, sportid:7, type:'NEIGE', name:'Ski', pref:2.0},
    {id:8, userid:4, sportid:6, type:'TERRE', name:'Chasse', pref:3.0},
    {id:9, userid:4, sportid:1, type:'EAU', name:'Kayak', pref:1.0},
]

const sportplaceassociation=[
    {userplaceid:5, usersportid:1},
    {userplaceid:6, usersportid:1},
    {userplaceid:5, usersportid:2},
    {userplaceid:6, usersportid:3},
    {userplaceid:5, usersportid:4},
    {userplaceid:6, usersportid:4},
    {userplaceid:6, usersportid:5},
    {userplaceid:7, usersportid:6},
    {userplaceid:8, usersportid:6},
    {userplaceid:7, usersportid:7},
    {userplaceid:8, usersportid:7},
    {userplaceid:7, usersportid:8},
    {userplaceid:8, usersportid:9}
]
export default {users, sports, places, userplaces, usersports, sportplaceassociation}
