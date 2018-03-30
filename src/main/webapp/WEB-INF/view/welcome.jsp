<%@ include file="common/header.jspf"%>

<div class="container">

	<%@ include file="common/navigation.jspf"%>

	<div class="well well-sm">
	<div class="container">
	  <div class="row">
	    <div class="col-sm">
	      	<h3>Knight's Fight</h3>
  			<p>Take a standard chess-board with 8x8 surfaces from 1-8 and A-H. Assume on the chess-board are only a white and a black knights presents.</p>
  			<p>Find out all the ways (positions) in which the jumpers threaten each other</p>
	    </div>
	  </div>
	  <form:form modelAttribute="knightPositions" id="knigtPositionForm">
		  <div class="row">
		    <div class="col-sm-6">
		      <p>Please select the start position of each knight in a standard 8X8 chess board: (like A6 or D3 or E2 )</p>
		      
		      <div class="row">
				<div class="col-md-10">
					<div class="form-group">
						<label class="required control-label" for="email">White Knight Position:</label>
						<form:input class="form-control" type="text" id="whiteKnightPosition" path="whiteKnightPosition" placeholder="${whiteKnightPosition}" maxlength="2" onkeyup="placeWhiteKnight(this);"/>
					</div>
				</div>
				<div class="col-md-10">
					<div class="form-group">
						<label class="required control-label" for="email">Black Knight Position:</label>
						<form:input class="form-control" type="text" id="blackKnightPosition" path="blackKnightPosition" placeholder="${blackKnightPosition}" maxlength="2" onkeyup="placeBlackKnight(this);"/>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group text-left">
						<input class="btn btn-success" type="button" name="btnClean" id="btnClean" value="Clear" onclick="clearKnights();">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group text-right">
						<input class="btn btn-success" type="button" name="btnGetKnightMoves" id="btnGetKnightMoves" value="Find Moves">
					</div>
				</div>
				<div class="col-md-10">
					<div class="form-group">
						<span id="whiteKnightMoves"></span>
					</div>
				</div>
				<div class="col-md-10">
					<div class="form-group">
						<span id="blackKnightMoves"></span>
					</div>
				</div>
			</div>
		    </div>
		    <div class="col-sm-4">
		      <table id='chessboard'></table>
		    </div>
		  </div>
		  
	  </form:form>
	</div>
	
	<!-- BLACK: &#9822; -->
	<!-- WHITE: &#9816; -->
  		
  	</div>
</div>
<%@ include file="common/footer.jspf"%>

<script>
var prevBlackKnightPos;
var prevWhiteKnightPos;
function placeWhiteKnight(knightPos){
	knightPos.value = knightPos.value.toUpperCase();
	if($("#knight"+knightPos.value)){
		if($("#knight"+knightPos.value).html() == ''){
			prevWhiteKnightPos = "knight"+knightPos.value;
			$("#knight"+knightPos.value).html($("#knight"+knightPos.value).html()+"&nbsp;"+"&#9816;");	
		}
	}
}
function placeBlackKnight(knightPos){
	knightPos.value = knightPos.value.toUpperCase();
	if($("#knight"+knightPos.value)){
		if($("#knight"+knightPos.value).html() == ''){
			prevBlackKnightPos = "knight"+knightPos.value;
			$("#knight"+knightPos.value).html($("#knight"+knightPos.value).html()+"&nbsp;"+"&#9822;");	
		}
		
	}
}
function clearKnights(){
	$("#blackKnightPosition").val("");
	$("#whiteKnightPosition").val("");
	$("#whiteKnightMoves").html("");
	$("#blackKnightMoves").html("");
	if($("#"+prevBlackKnightPos)){
		$("#"+prevBlackKnightPos).html("");
		prevBlackKnightPos = "";
	}
	
	if($("#"+prevWhiteKnightPos)){
		$("#"+prevWhiteKnightPos).html("");
		prevWhiteKnightPos = "";
	}
}

$( document ).ready(function() {
	
	// GET REQUEST
	$("#btnGetKnightMoves").click(function(event){
		event.preventDefault();
		ajaxGet();
	});
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : window.location + "knight-moves/"+$('#whiteKnightPosition').val()+"/"+$('#blackKnightPosition').val(),
			success: function(result){
				if(result.status == "Success"){
					$("#whiteKnightMoves").html("White Knight Moves: "+result.whiteKnightPath);
					$("#blackKnightMoves").html("Black Knight Moves: "+result.blackKnightPath);
					console.log("Success: ", result);
				}else{
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});	
	}
})

var prevBackground;

function unhighlight(pos) {
  $("#"+pos).css('background-color', prevBackground);
}

function highlight(pos) {
	prevBackground = $("#"+pos).css( "background-color" );
	$("#"+pos).css('background-color', '#f7dc6f');
}

</script>
