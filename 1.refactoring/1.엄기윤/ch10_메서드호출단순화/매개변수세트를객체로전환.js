/*
자주 붙어서 다니는 매개변수가 있다면
그것들을 묶어서 객체로 만들어 사용하자

*/
var eat;
var walk;

var routine = function(eat, walk){
	this.eat = eat;
	this.walk = walk;
}
//////////////////////////////////////////
function people(eat,walk ){
	console.log(eat)
	console.log(walk)
}

function people(routine){
	console.log(routine.eat)
	console.log(routine.walk)
	
}