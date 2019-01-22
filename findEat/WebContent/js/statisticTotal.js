/**
 * 	statistic - total
 */
$(".list-group-item").click(function(){
	var cls = "."+$(this).children(".dayHead").text()+"Chk";
	var chk = $(cls).val();
	var foodTotal	= "#"+$(this).children(".dayHead").text()+"-food-total";
	var cateTotal	= "#"+$(this).children(".dayHead").text()+"-category-total";
	if(chk==0){
		$(cateTotal).removeAttr("hidden");
		$(foodTotal).attr("hidden",true);
		$(cls).val("1");
	}else {
		$(foodTotal).removeAttr("hidden");
		$(cateTotal).attr("hidden",true);
		$(cls).val("0");
	}
});
var foodMonthTotal = bb.generate({
	data: {
		columns: [
			[$('.food-total-key-1'),$('.food-total-value-1')],
			[$('.food-total-key-2'),$('.food-total-value-2')],
			[$('.food-total-key-3'),$('.food-total-value-3')],
			[$('.food-total-key-4'),$('.food-total-value-4')],
			[$('.food-total-key-5'),$('.food-total-value-5')],
			[$('.food-total-key-6'),$('.food-total-value-6')],
			[$('.food-total-key-7'),$('.food-total-value-7')],
			[$('.food-total-key-8'),$('.food-total-value-8')],
			[$('.food-total-key-9'),$('.food-total-value-9')],
			[$('.food-total-key-10'),$('.food-total-value-10')]
		],
		type: "pie",
		onclick: function(d, i) {
			console.log("onover", d, i);
		},
		onover: function(d, i) {
			console.log("onover", d, i);
		},
		onout: function(d, i) {
			console.log("onout", d, i);
		}
		},
	size: {
		"width": 300,
		"height": 300
	},
	bindto: "#foodMonth-total"
});
var categoryMonthTotal = bb.generate({
	data: {
		columns: [
			['test1',20],
			['test2',10],
			['test3',40],
			['test4',15],
			['test5',15],
			['test6',9]
		],
		type: "pie",
		onclick: function(d, i) {
			console.log("onover", d, i);
		},
		onover: function(d, i) {
			console.log("onover", d, i);
		},
		onout: function(d, i) {
			console.log("onout", d, i);
		}
		},
	size: {
		"width": 300,
		"height": 300
	},
	bindto: "#categoryMonth-total"
});

var monFoodTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			["data1",10],
			["data2",20],
			["data3",40]
		],
		type: "bar",
		groups: [
			["data1","data2","data3"]
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
		"width": 165
	},
	bindto: "#Monday-food-total"
});
var monCategoryTotal = bb.generate({
	data:{
		x: "x",
		columns:[
			["x","Food"],
			["data1",10],
			["data2",20],
			["data3",40]
		],
		type: "bar",
		groups: [
			["data1","data2","data3"]
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
		"width": 165
	},
	bindto: "#Monday-category-total"
});