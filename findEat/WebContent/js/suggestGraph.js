
/******************************************/
//Script - suggestion ver2
var totalRank = bb.generate({
	data: {
		columns: [
			[$(".totalRankMapKey-1").val(), Number($(".totalRankMapValue-1").val())],
			[$(".totalRankMapKey-2").val(), Number($(".totalRankMapValue-2").val())],
			[$(".totalRankMapKey-3").val(), Number($(".totalRankMapValue-3").val())],
			[$(".totalRankMapKey-4").val(), Number($(".totalRankMapValue-4").val())],
			[$(".totalRankMapKey-5").val(), Number($(".totalRankMapValue-5").val())]
		],
		type: "pie",
		onclick: function(d, i) {
			window.location.href = "/findEat/search.do?keyword="+d.id;
		},
		onover: function(d, i) {
		},
		onout: function(d, i) {
		}
		},
	size: {
		"width": 235,
		"height": 235
	},
	bindto: "#totalTabPie-total"
});
//Script
var chartB = bb.generate({
  data: {
    columns: [
    	[$(".totalClasMapKey-1").val(), $(".totalClasMapValue-1").val()],
		[$(".totalClasMapKey-2").val(), $(".totalClasMapValue-2").val()],
		[$(".totalClasMapKey-3").val(), $(".totalClasMapValue-3").val()],
		[$(".totalClasMapKey-4").val(), $(".totalClasMapValue-4").val()],
		[$(".totalClasMapKey-5").val(), $(".totalClasMapValue-5").val()],
		[$(".totalClasMapKey-6").val(), $(".totalClasMapValue-6").val()]
    ],
    type: "donut"
  },
  donut: {
    title: "음식 유형",
    label: {
      ratio: 1.5
    }
  },
  legend: {
    show: true
  },
  size: {
		"width": 235,
		"height": 235
  },
  bindto: "#totalTabPie-totalB"
});

//////////user total
var userRank = bb.generate({
	data: {
		columns: [
			[$(".userRankMapKey-1").val(), Number($(".userRankMapValue-1").val())],
			[$(".userRankMapKey-2").val(), Number($(".userRankMapValue-2").val())],
			[$(".userRankMapKey-3").val(), Number($(".userRankMapValue-3").val())],
			[$(".userRankMapKey-4").val(), Number($(".userRankMapValue-4").val())],
			[$(".userRankMapKey-5").val(), Number($(".userRankMapValue-5").val())]
			],
		type: "pie",
		onclick: function(d, i) {
			window.location.href = "/findEat/search.do?keyword="+d.id;
		},
		onover: function(d, i) {
		},
		onout: function(d, i) {
		}
	},
	  size: {
			"width": 235,
			"height": 235
	  },
	bindto: "#userTabPie-total"
});
//total - user classify
var userRankB = bb.generate({
	data: {
		columns: [
			[$(".userClasMapKey-1").val(), $(".userClasMapValue-1").val()],
			[$(".userClasMapKey-2").val(), $(".userClasMapValue-2").val()],
			[$(".userClasMapKey-3").val(), $(".userClasMapValue-3").val()],
			[$(".userClasMapKey-4").val(), $(".userClasMapValue-4").val()],
			[$(".userClasMapKey-5").val(), $(".userClasMapValue-5").val()],
			[$(".userClasMapKey-6").val(), $(".userClasMapValue-6").val()]
		],
		type: "donut"
	},
	donut: {
		title: "음식 유형",
		label: {
			ratio: 1.5
		}
	},
	legend: {
		show: true
	},
	size: {
		"width": 235,
		"height": 235
	},
	bindto: "#userTabPie-totalB"
});

////////ready to show------------------
$(document).ready(function(){

	//total---------------------------------------------////////////////////////////////////////
	var totalKRank = bb.generate({
		  data: {
		    columns: [
		    	[$(".totalKMapKey-1").val(), Number($(".totalKMapValue-1").val())],
				[$(".totalKMapKey-2").val(), Number($(".totalKMapValue-2").val())],
				[$(".totalKMapKey-3").val(), Number($(".totalKMapValue-3").val())],
				[$(".totalKMapKey-4").val(), Number($(".totalKMapValue-4").val())],
				[$(".totalKMapKey-5").val(), Number($(".totalKMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#totalTabPie-k"
	});
	var totalJRank = bb.generate({
		  data: {
		    columns: [
		    	[$(".totalJMapKey-1").val(), Number($(".totalJMapValue-1").val())],
				[$(".totalJMapKey-2").val(), Number($(".totalJMapValue-2").val())],
				[$(".totalJMapKey-3").val(), Number($(".totalJMapValue-3").val())],
				[$(".totalJMapKey-4").val(), Number($(".totalJMapValue-4").val())],
				[$(".totalJMapKey-5").val(), Number($(".totalJMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#totalTabPie-j"
	});
	var totalCRank = bb.generate({
		  data: {
		    columns: [
		    	[$(".totalCMapKey-1").val(), Number($(".totalCMapValue-1").val())],
				[$(".totalCMapKey-2").val(), Number($(".totalCMapValue-2").val())],
				[$(".totalCMapKey-3").val(), Number($(".totalCMapValue-3").val())],
				[$(".totalCMapKey-4").val(), Number($(".totalCMapValue-4").val())],
				[$(".totalCMapKey-5").val(), Number($(".totalCMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#totalTabPie-c"
	});
	var totalWRank = bb.generate({
		  data: {
		    columns: [
		    	[$(".totalWMapKey-1").val(), Number($(".totalWMapValue-1").val())],
				[$(".totalWMapKey-2").val(), Number($(".totalWMapValue-2").val())],
				[$(".totalWMapKey-3").val(), Number($(".totalWMapValue-3").val())],
				[$(".totalWMapKey-4").val(), Number($(".totalWMapValue-4").val())],
				[$(".totalWMapKey-5").val(), Number($(".totalWMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#totalTabPie-w"
	});
	var totalFRank = bb.generate({
		  data: {
		    columns: [
		    	[$(".totalFMapKey-1").val(), Number($(".totalFMapValue-1").val())],
				[$(".totalFMapKey-2").val(), Number($(".totalFMapValue-2").val())],
				[$(".totalFMapKey-3").val(), Number($(".totalFMapValue-3").val())],
				[$(".totalFMapKey-4").val(), Number($(".totalFMapValue-4").val())],
				[$(".totalFMapKey-5").val(), Number($(".totalFMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#totalTabPie-f"
	});
	var totalERank = bb.generate({
		  data: {
		    columns: [
		    	[$(".totalEMapKey-1").val(), Number($(".totalEMapValue-1").val())],
				[$(".totalEMapKey-2").val(), Number($(".totalEMapValue-2").val())],
				[$(".totalEMapKey-3").val(), Number($(".totalEMapValue-3").val())],
				[$(".totalEMapKey-4").val(), Number($(".totalEMapValue-4").val())],
				[$(".totalEMapKey-5").val(), Number($(".totalEMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#totalTabPie-e"
	});
	//user---------------------------------------------////////////////////////////////////////
	var userKRank = bb.generate({
		  data: {
		    columns: [
				[$(".userKMapKey-1").val(), Number($(".userKMapValue-1").val())],
				[$(".userKMapKey-2").val(), Number($(".userKMapValue-2").val())],
				[$(".userKMapKey-3").val(), Number($(".userKMapValue-3").val())],
				[$(".userKMapKey-4").val(), Number($(".userKMapValue-4").val())],
				[$(".userKMapKey-5").val(), Number($(".userKMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#userTabPie-k"
	});
	var userJRank = bb.generate({
		  data: {
		    columns: [
				[$(".userJMapKey-1").val(), Number($(".userJMapValue-1").val())],
				[$(".userJMapKey-2").val(), Number($(".userJMapValue-2").val())],
				[$(".userJMapKey-3").val(), Number($(".userJMapValue-3").val())],
				[$(".userJMapKey-4").val(), Number($(".userJMapValue-4").val())],
				[$(".userJMapKey-5").val(), Number($(".userJMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#userTabPie-j"
	});
	var userCRank = bb.generate({
		  data: {
		    columns: [
				[$(".userCMapKey-1").val(), Number($(".userCMapValue-1").val())],
				[$(".userCMapKey-2").val(), Number($(".userCMapValue-2").val())],
				[$(".userCMapKey-3").val(), Number($(".userCMapValue-3").val())],
				[$(".userCMapKey-4").val(), Number($(".userCMapValue-4").val())],
				[$(".userCMapKey-5").val(), Number($(".userCMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#userTabPie-c"
	});
	var userWRank = bb.generate({
		  data: {
		    columns: [
				[$(".userWMapKey-1").val(), Number($(".userWMapValue-1").val())],
				[$(".userWMapKey-2").val(), Number($(".userWMapValue-2").val())],
				[$(".userWMapKey-3").val(), Number($(".userWMapValue-3").val())],
				[$(".userWMapKey-4").val(), Number($(".userWMapValue-4").val())],
				[$(".userWMapKey-5").val(), Number($(".userWMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#userTabPie-w"
	});
	var userFRank = bb.generate({
		  data: {
		    columns: [
				[$(".userFMapKey-1").val(), Number($(".userFMapValue-1").val())],
				[$(".userFMapKey-2").val(), Number($(".userFMapValue-2").val())],
				[$(".userFMapKey-3").val(), Number($(".userFMapValue-3").val())],
				[$(".userFMapKey-4").val(), Number($(".userFMapValue-4").val())],
				[$(".userFMapKey-5").val(), Number($(".userFMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#userTabPie-f"
	});
	var userERank = bb.generate({
		  data: {
		    columns: [
				[$(".userEMapKey-1").val(), Number($(".userEMapValue-1").val())],
				[$(".userEMapKey-2").val(), Number($(".userEMapValue-2").val())],
				[$(".userEMapKey-3").val(), Number($(".userEMapValue-3").val())],
				[$(".userEMapKey-4").val(), Number($(".userEMapValue-4").val())],
				[$(".userEMapKey-5").val(), Number($(".userEMapValue-5").val())]
		    ],
		    type: "pie",
		    onclick: function(d, i) {
				window.location.href = "/findEat/search.do?keyword="+d.id;
		   },
		    onover: function(d, i) {
		   },
		    onout: function(d, i) {
		   }
		  },
		  size: {
				"width": 235,
				"height": 235
		  },
		  bindto: "#userTabPie-e"
	});
});


