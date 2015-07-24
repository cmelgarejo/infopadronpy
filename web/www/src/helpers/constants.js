module.exports = {
    qualities: ["Ninguno", "Tipo 1 Bra", "Grado 2 Arg", "Maiz de segunda"
    ],
    maxPages: 5,
    defaultAuctionParams: function () {
        return "quality=1,2,3&volume=lt100,bw100n500,gt500&state=active&owner=all&sort=edd&quantity=" + this.maxPages;
    },
    devmode: true ,
    traderid:null
};


