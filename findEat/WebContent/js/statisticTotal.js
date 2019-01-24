/**
 * 	statistic - total
 */
//button click!!
$("#userBtn").click(function(){
	var chk	= $("#btnChk").val();
	if(chk==0){
		$("#statisticTotal").attr("hidden",true);
		$("#statisticUser").removeAttr("hidden");
		$("#btnChk").val(1);
		$("#totalBtn").removeClass("btn-dark");
		$("#totalBtn").addClass("btn-light");
		$("#userBtn").removeClass("btn-light");
		$("#userBtn").addClass("btn-dark");
	}
});
$("#totalBtn").click(function(){
	var chk	= $("#btnChk").val();
	if(chk==1) {
		$("#statisticUser").attr("hidden",true);
		$("#statisticTotal").removeAttr("hidden");
		$("#btnChk").val(0);
		$("#totalBtn").removeClass("btn-light");
		$("#totalBtn").addClass("btn-dark");
		$("#userBtn").removeClass("btn-dark");
		$("#userBtn").addClass("btn-light");
	}
});
//day div click!!
$(".list-group-item").click(function(){
	var cls = "."+$(this).children(".dayHead").text()+"Chk";
	var chk = $(cls).val();
	var foodTotal	= "#"+$(this).children(".dayHead").text()+"-food-total";
	var cateTotal	= "#"+$(this).children(".dayHead").text()+"-category-total";
	var foodUser	= "#"+$(this).children(".dayHead").text()+"-food-user";
	var cateUser	= "#"+$(this).children(".dayHead").text()+"-category-user";
	if(chk==0){
		$(cateTotal).removeAttr("hidden");
		$(foodTotal).attr("hidden",true);
		$(cateUser).removeAttr("hidden");
		$(foodUser).attr("hidden",true);
		$(cls).val("1");
	}else {
		$(foodTotal).removeAttr("hidden");
		$(cateTotal).attr("hidden",true);
		$(foodUser).removeAttr("hidden");
		$(cateUser).attr("hidden",true);
		$(cls).val("0");
	}
});
///////*************************************************************total
var foodMonthTotal = bb.generate({
	data: {
		columns: [
			[$('.food-total-key-1').val(),$('.food-total-value-1').val()],
			[$('.food-total-key-2').val(),$('.food-total-value-2').val()],
			[$('.food-total-key-3').val(),$('.food-total-value-3').val()],
			[$('.food-total-key-4').val(),$('.food-total-value-4').val()],
			[$('.food-total-key-5').val(),$('.food-total-value-5').val()],
			[$('.food-total-key-6').val(),$('.food-total-value-6').val()],
			[$('.food-total-key-7').val(),$('.food-total-value-7').val()],
			[$('.food-total-key-8').val(),$('.food-total-value-8').val()],
			[$('.food-total-key-9').val(),$('.food-total-value-9').val()],
			[$('.food-total-key-10').val(),$('.food-total-value-10').val()]
		],
		type: "pie",
		onclick: function(d, i) {
			console.log("onover", d, i);
		}
		},
	size: {
		"width": 350,
		"height": 300
	},
	bindto: "#foodMonth-total"
});
var categoryMonthTotal = bb.generate({
	data: {
		columns: [
			[$('.category-total-key-1').val(),$('.category-total-value-1').val()],
			[$('.category-total-key-2').val(),$('.category-total-value-2').val()],
			[$('.category-total-key-3').val(),$('.category-total-value-3').val()],
			[$('.category-total-key-4').val(),$('.category-total-value-4').val()],
			[$('.category-total-key-5').val(),$('.category-total-value-5').val()],
			[$('.category-total-key-6').val(),$('.category-total-value-6').val()]
		],
		type: "pie",
		onclick: function(d, i) {
			console.log("onover", d, i);
		}
		},
	size: {
		"width": 350,
		"height": 300
	},
	bindto: "#categoryMonth-total"
});

var monFoodTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.monFood-total-key-1').val(),$('.monFood-total-value-1').val()],
			[$('.monFood-total-key-2').val(),$('.monFood-total-value-2').val()],
			[$('.monFood-total-key-3').val(),$('.monFood-total-value-3').val()],
			[$('.monFood-total-key-4').val(),$('.monFood-total-value-4').val()],
			[$('.monFood-total-key-5').val(),$('.monFood-total-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.monFood-total-key-1').val(),
			 $('.monFood-total-key-2').val(),
			 $('.monFood-total-key-3').val(),
			 $('.monFood-total-key-4').val(),
			 $('.monFood-total-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Monday-food-total"
});
var monCategoryTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.monCategory-total-key-1').val(),$('.monCategory-total-value-1').val()],
			[$('.monCategory-total-key-2').val(),$('.monCategory-total-value-2').val()],
			[$('.monCategory-total-key-3').val(),$('.monCategory-total-value-3').val()],
			[$('.monCategory-total-key-4').val(),$('.monCategory-total-value-4').val()],
			[$('.monCategory-total-key-5').val(),$('.monCategory-total-value-5').val()],
			[$('.monCategory-total-key-6').val(),$('.monCategory-total-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.monCategory-total-key-1').val(),
			 $('.monCategory-total-key-2').val(),
			 $('.monCategory-total-key-3').val(),
			 $('.monCategory-total-key-4').val(),
			 $('.monCategory-total-key-5').val(),
			 $('.monCategory-total-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Monday-category-total"
});
//Tuesday 							******************************************************************************//
var tueFoodTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.tueFood-total-key-1').val(),$('.tueFood-total-value-1').val()],
			[$('.tueFood-total-key-2').val(),$('.tueFood-total-value-2').val()],
			[$('.tueFood-total-key-3').val(),$('.tueFood-total-value-3').val()],
			[$('.tueFood-total-key-4').val(),$('.tueFood-total-value-4').val()],
			[$('.tueFood-total-key-5').val(),$('.tueFood-total-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.tueFood-total-key-1').val(),
			 $('.tueFood-total-key-2').val(),
			 $('.tueFood-total-key-3').val(),
			 $('.tueFood-total-key-4').val(),
			 $('.tueFood-total-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Tuesday-food-total"
});
var tueCategoryTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.tueCategory-total-key-1').val(),$('.tueCategory-total-value-1').val()],
			[$('.tueCategory-total-key-2').val(),$('.tueCategory-total-value-2').val()],
			[$('.tueCategory-total-key-3').val(),$('.tueCategory-total-value-3').val()],
			[$('.tueCategory-total-key-4').val(),$('.tueCategory-total-value-4').val()],
			[$('.tueCategory-total-key-5').val(),$('.tueCategory-total-value-5').val()],
			[$('.tueCategory-total-key-6').val(),$('.tueCategory-total-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.tueCategory-total-key-1').val(),
			 $('.tueCategory-total-key-2').val(),
			 $('.tueCategory-total-key-3').val(),
			 $('.tueCategory-total-key-4').val(),
			 $('.tueCategory-total-key-5').val(),
			 $('.tueCategory-total-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Tuesday-category-total"
});
//Wednesday 							******************************************************************************//
var wedFoodTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.wedFood-total-key-1').val(),$('.wedFood-total-value-1').val()],
			[$('.wedFood-total-key-2').val(),$('.wedFood-total-value-2').val()],
			[$('.wedFood-total-key-3').val(),$('.wedFood-total-value-3').val()],
			[$('.wedFood-total-key-4').val(),$('.wedFood-total-value-4').val()],
			[$('.wedFood-total-key-5').val(),$('.wedFood-total-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.wedFood-total-key-1').val(),
			 $('.wedFood-total-key-2').val(),
			 $('.wedFood-total-key-3').val(),
			 $('.wedFood-total-key-4').val(),
			 $('.wedFood-total-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Wednesday-food-total"
});
var wedCategoryTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.wedCategory-total-key-1').val(),$('.wedCategory-total-value-1').val()],
			[$('.wedCategory-total-key-2').val(),$('.wedCategory-total-value-2').val()],
			[$('.wedCategory-total-key-3').val(),$('.wedCategory-total-value-3').val()],
			[$('.wedCategory-total-key-4').val(),$('.wedCategory-total-value-4').val()],
			[$('.wedCategory-total-key-5').val(),$('.wedCategory-total-value-5').val()],
			[$('.wedCategory-total-key-6').val(),$('.wedCategory-total-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.wedCategory-total-key-1').val(),
			 $('.wedCategory-total-key-2').val(),
			 $('.wedCategory-total-key-3').val(),
			 $('.wedCategory-total-key-4').val(),
			 $('.wedCategory-total-key-5').val(),
			 $('.wedCategory-total-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Wednesday-category-total"
});
//Thursday 							******************************************************************************//
var thuFoodTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.thuFood-total-key-1').val(),$('.thuFood-total-value-1').val()],
			[$('.thuFood-total-key-2').val(),$('.thuFood-total-value-2').val()],
			[$('.thuFood-total-key-3').val(),$('.thuFood-total-value-3').val()],
			[$('.thuFood-total-key-4').val(),$('.thuFood-total-value-4').val()],
			[$('.thuFood-total-key-5').val(),$('.thuFood-total-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.thuFood-total-key-1').val(),
			 $('.thuFood-total-key-2').val(),
			 $('.thuFood-total-key-3').val(),
			 $('.thuFood-total-key-4').val(),
			 $('.thuFood-total-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Thursday-food-total"
});
var wedCategoryTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.thuCategory-total-key-1').val(),$('.thuCategory-total-value-1').val()],
			[$('.thuCategory-total-key-2').val(),$('.thuCategory-total-value-2').val()],
			[$('.thuCategory-total-key-3').val(),$('.thuCategory-total-value-3').val()],
			[$('.thuCategory-total-key-4').val(),$('.thuCategory-total-value-4').val()],
			[$('.thuCategory-total-key-5').val(),$('.thuCategory-total-value-5').val()],
			[$('.thuCategory-total-key-6').val(),$('.thuCategory-total-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.thuCategory-total-key-1').val(),
			 $('.thuCategory-total-key-2').val(),
			 $('.thuCategory-total-key-3').val(),
			 $('.thuCategory-total-key-4').val(),
			 $('.thuCategory-total-key-5').val(),
			 $('.thuCategory-total-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Thursday-category-total"
});
//Friday 							******************************************************************************//
var friFoodTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.friFood-total-key-1').val(),$('.friFood-total-value-1').val()],
			[$('.friFood-total-key-2').val(),$('.friFood-total-value-2').val()],
			[$('.friFood-total-key-3').val(),$('.friFood-total-value-3').val()],
			[$('.friFood-total-key-4').val(),$('.friFood-total-value-4').val()],
			[$('.friFood-total-key-5').val(),$('.friFood-total-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.friFood-total-key-1').val(),
			 $('.friFood-total-key-2').val(),
			 $('.friFood-total-key-3').val(),
			 $('.friFood-total-key-4').val(),
			 $('.friFood-total-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Friday-food-total"
});
var friCategoryTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.friCategory-total-key-1').val(),$('.friCategory-total-value-1').val()],
			[$('.friCategory-total-key-2').val(),$('.friCategory-total-value-2').val()],
			[$('.friCategory-total-key-3').val(),$('.friCategory-total-value-3').val()],
			[$('.friCategory-total-key-4').val(),$('.friCategory-total-value-4').val()],
			[$('.friCategory-total-key-5').val(),$('.friCategory-total-value-5').val()],
			[$('.friCategory-total-key-6').val(),$('.friCategory-total-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.friCategory-total-key-1').val(),
			 $('.friCategory-total-key-2').val(),
			 $('.friCategory-total-key-3').val(),
			 $('.friCategory-total-key-4').val(),
			 $('.friCategory-total-key-5').val(),
			 $('.friCategory-total-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Friday-category-total"
});

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//****************************user
var foodMonthUser = bb.generate({
	data: {
		columns: [
			[$('.food-user-key-1').val(),$('.food-user-value-1').val()],
			[$('.food-user-key-2').val(),$('.food-user-value-2').val()],
			[$('.food-user-key-3').val(),$('.food-user-value-3').val()],
			[$('.food-user-key-4').val(),$('.food-user-value-4').val()],
			[$('.food-user-key-5').val(),$('.food-user-value-5').val()],
			[$('.food-user-key-6').val(),$('.food-user-value-6').val()],
			[$('.food-user-key-7').val(),$('.food-user-value-7').val()],
			[$('.food-user-key-8').val(),$('.food-user-value-8').val()],
			[$('.food-user-key-9').val(),$('.food-user-value-9').val()],
			[$('.food-user-key-10').val(),$('.food-user-value-10').val()]
		],
		type: "pie",
		onclick: function(d, i) {
			console.log("onover", d, i);
		}
		},
	size: {
		"width": 350,
		"height": 300
	},
	bindto: "#foodMonth-user"
});
var categoryMonthUser = bb.generate({
	data: {
		columns: [
			[$('.category-user-key-1').val(),$('.category-user-value-1').val()],
			[$('.category-user-key-2').val(),$('.category-user-value-2').val()],
			[$('.category-user-key-3').val(),$('.category-user-value-3').val()],
			[$('.category-user-key-4').val(),$('.category-user-value-4').val()],
			[$('.category-user-key-5').val(),$('.category-user-value-5').val()],
			[$('.category-user-key-6').val(),$('.category-user-value-6').val()]
		],
		type: "pie",
		onclick: function(d, i) {
			console.log("onover", d, i);
		}
		},
	size: {
		"width": 350,
		"height": 300
	},
	bindto: "#categoryMonth-user"
});

var monFoodUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.monFood-user-key-1').val(),$('.monFood-user-value-1').val()],
			[$('.monFood-user-key-2').val(),$('.monFood-user-value-2').val()],
			[$('.monFood-user-key-3').val(),$('.monFood-user-value-3').val()],
			[$('.monFood-user-key-4').val(),$('.monFood-user-value-4').val()],
			[$('.monFood-user-key-5').val(),$('.monFood-user-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.monFood-user-key-1').val(),
			 $('.monFood-user-key-2').val(),
			 $('.monFood-user-key-3').val(),
			 $('.monFood-user-key-4').val(),
			 $('.monFood-user-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Monday-food-user"
});
var monCategoryUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.monCategory-user-key-1').val(),$('.monCategory-user-value-1').val()],
			[$('.monCategory-user-key-2').val(),$('.monCategory-user-value-2').val()],
			[$('.monCategory-user-key-3').val(),$('.monCategory-user-value-3').val()],
			[$('.monCategory-user-key-4').val(),$('.monCategory-user-value-4').val()],
			[$('.monCategory-user-key-5').val(),$('.monCategory-user-value-5').val()],
			[$('.monCategory-user-key-6').val(),$('.monCategory-user-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.monCategory-user-key-1').val(),
			 $('.monCategory-user-key-2').val(),
			 $('.monCategory-user-key-3').val(),
			 $('.monCategory-user-key-4').val(),
			 $('.monCategory-user-key-5').val(),
			 $('.monCategory-user-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Monday-category-user"
});
//Tuesday 							******************************************************************************//
var tueFoodUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.tueFood-user-key-1').val(),$('.tueFood-user-value-1').val()],
			[$('.tueFood-user-key-2').val(),$('.tueFood-user-value-2').val()],
			[$('.tueFood-user-key-3').val(),$('.tueFood-user-value-3').val()],
			[$('.tueFood-user-key-4').val(),$('.tueFood-user-value-4').val()],
			[$('.tueFood-user-key-5').val(),$('.tueFood-user-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.tueFood-user-key-1').val(),
			 $('.tueFood-user-key-2').val(),
			 $('.tueFood-user-key-3').val(),
			 $('.tueFood-user-key-4').val(),
			 $('.tueFood-user-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Tuesday-food-user"
});
var tueCategoryUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.tueCategory-user-key-1').val(),$('.tueCategory-user-value-1').val()],
			[$('.tueCategory-user-key-2').val(),$('.tueCategory-user-value-2').val()],
			[$('.tueCategory-user-key-3').val(),$('.tueCategory-user-value-3').val()],
			[$('.tueCategory-user-key-4').val(),$('.tueCategory-user-value-4').val()],
			[$('.tueCategory-user-key-5').val(),$('.tueCategory-user-value-5').val()],
			[$('.tueCategory-user-key-6').val(),$('.tueCategory-user-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.tueCategory-user-key-1').val(),
			 $('.tueCategory-user-key-2').val(),
			 $('.tueCategory-user-key-3').val(),
			 $('.tueCategory-user-key-4').val(),
			 $('.tueCategory-user-key-5').val(),
			 $('.tueCategory-user-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Tuesday-category-user"
});
//Wednesday 							******************************************************************************//
var wedFoodUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.wedFood-user-key-1').val(),$('.wedFood-user-value-1').val()],
			[$('.wedFood-user-key-2').val(),$('.wedFood-user-value-2').val()],
			[$('.wedFood-user-key-3').val(),$('.wedFood-user-value-3').val()],
			[$('.wedFood-user-key-4').val(),$('.wedFood-user-value-4').val()],
			[$('.wedFood-user-key-5').val(),$('.wedFood-user-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.wedFood-user-key-1').val(),
			 $('.wedFood-user-key-2').val(),
			 $('.wedFood-user-key-3').val(),
			 $('.wedFood-user-key-4').val(),
			 $('.wedFood-user-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Wednesday-food-user"
});
var wedCategoryUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.wedCategory-user-key-1').val(),$('.wedCategory-user-value-1').val()],
			[$('.wedCategory-user-key-2').val(),$('.wedCategory-user-value-2').val()],
			[$('.wedCategory-user-key-3').val(),$('.wedCategory-user-value-3').val()],
			[$('.wedCategory-user-key-4').val(),$('.wedCategory-user-value-4').val()],
			[$('.wedCategory-user-key-5').val(),$('.wedCategory-user-value-5').val()],
			[$('.wedCategory-user-key-6').val(),$('.wedCategory-user-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.wedCategory-user-key-1').val(),
			 $('.wedCategory-user-key-2').val(),
			 $('.wedCategory-user-key-3').val(),
			 $('.wedCategory-user-key-4').val(),
			 $('.wedCategory-user-key-5').val(),
			 $('.wedCategory-user-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Wednesday-category-user"
});
//Thursday 							******************************************************************************//
var thuFoodUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.thuFood-user-key-1').val(),$('.thuFood-user-value-1').val()],
			[$('.thuFood-user-key-2').val(),$('.thuFood-user-value-2').val()],
			[$('.thuFood-user-key-3').val(),$('.thuFood-user-value-3').val()],
			[$('.thuFood-user-key-4').val(),$('.thuFood-user-value-4').val()],
			[$('.thuFood-user-key-5').val(),$('.thuFood-user-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.thuFood-user-key-1').val(),
			 $('.thuFood-user-key-2').val(),
			 $('.thuFood-user-key-3').val(),
			 $('.thuFood-user-key-4').val(),
			 $('.thuFood-user-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Thursday-food-user"
});
var wedCategoryUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.thuCategory-user-key-1').val(),$('.thuCategory-user-value-1').val()],
			[$('.thuCategory-user-key-2').val(),$('.thuCategory-user-value-2').val()],
			[$('.thuCategory-user-key-3').val(),$('.thuCategory-user-value-3').val()],
			[$('.thuCategory-user-key-4').val(),$('.thuCategory-user-value-4').val()],
			[$('.thuCategory-user-key-5').val(),$('.thuCategory-user-value-5').val()],
			[$('.thuCategory-user-key-6').val(),$('.thuCategory-user-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.thuCategory-user-key-1').val(),
			 $('.thuCategory-user-key-2').val(),
			 $('.thuCategory-user-key-3').val(),
			 $('.thuCategory-user-key-4').val(),
			 $('.thuCategory-user-key-5').val(),
			 $('.thuCategory-user-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Thursday-category-user"
});
//Friday 							******************************************************************************//
var friFoodUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.friFood-user-key-1').val(),$('.friFood-user-value-1').val()],
			[$('.friFood-user-key-2').val(),$('.friFood-user-value-2').val()],
			[$('.friFood-user-key-3').val(),$('.friFood-user-value-3').val()],
			[$('.friFood-user-key-4').val(),$('.friFood-user-value-4').val()],
			[$('.friFood-user-key-5').val(),$('.friFood-user-value-5').val()]
		],
		type: "bar",
		groups: [
			[$('.friFood-user-key-1').val(),
			 $('.friFood-user-key-2').val(),
			 $('.friFood-user-key-3').val(),
			 $('.friFood-user-key-4').val(),
			 $('.friFood-user-key-5').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Food"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Friday-food-user"
});
var friCategoryUser = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			[$('.friCategory-user-key-1').val(),$('.friCategory-user-value-1').val()],
			[$('.friCategory-user-key-2').val(),$('.friCategory-user-value-2').val()],
			[$('.friCategory-user-key-3').val(),$('.friCategory-user-value-3').val()],
			[$('.friCategory-user-key-4').val(),$('.friCategory-user-value-4').val()],
			[$('.friCategory-user-key-5').val(),$('.friCategory-user-value-5').val()],
			[$('.friCategory-user-key-6').val(),$('.friCategory-user-value-6').val()]
		],
		type: "bar",
		groups: [
			[$('.friCategory-user-key-1').val(),
			 $('.friCategory-user-key-2').val(),
			 $('.friCategory-user-key-3').val(),
			 $('.friCategory-user-key-4').val(),
			 $('.friCategory-user-key-5').val(),
			 $('.friCategory-user-key-6').val()]
		],
		stack: {
			normalize: true
		}
	},
	axis: {
		x: {
			type: "category"
		}
	},
	title: {
		text: "Category"
	},
	size: {
		width: 160
	},
	bar: {
        width: {
            max: 45
        }
    },
    tooltip: {
    	order: "desc"
    },
	bindto: "#Friday-category-user"
});