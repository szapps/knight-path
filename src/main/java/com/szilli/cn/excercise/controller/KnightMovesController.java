package com.szilli.cn.excercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szilli.cn.excercise.model.ChessPosition;
import com.szilli.cn.excercise.model.Knight;
import com.szilli.cn.excercise.model.KnightMovesResponse;
import com.szilli.cn.excercise.model.YCoordinate;
import com.szilli.cn.excercise.service.ChessPlayerMovesService;
import com.szilli.cn.excercise.service.KnightMovesService;

@RestController
@RequestMapping("/knight-moves")
public class KnightMovesController {
	@GetMapping(value = "/{whiteKnightPosition}/{blackKnightPosition}")
	public KnightMovesResponse getResource(@PathVariable final String whiteKnightPosition,
			@PathVariable final String blackKnightPosition) {

		ChessPlayerMovesService whiteKnightMovesService = new KnightMovesService(
				new ChessPosition(YCoordinate.valueOf(whiteKnightPosition.substring(0, 1)).getValue(),
						Integer.parseInt(whiteKnightPosition.substring(1))),
				new ChessPosition(YCoordinate.valueOf(blackKnightPosition.substring(0, 1)).getValue(),
						Integer.parseInt(blackKnightPosition.substring(1))),
				new Knight());
		String whiteKnightMoves = whiteKnightMovesService.getMovesToDestinationPosition();
		String[] arrWhiteKnightMoves = whiteKnightMoves.split(" ");

		ChessPlayerMovesService blackKnightMovesService = new KnightMovesService(
				new ChessPosition(YCoordinate.valueOf(blackKnightPosition.substring(0, 1)).getValue(),
						Integer.parseInt(blackKnightPosition.substring(1))),
				new ChessPosition(YCoordinate.valueOf(whiteKnightPosition.substring(0, 1)).getValue(),
						Integer.parseInt(whiteKnightPosition.substring(1))),
				new Knight());
		String blackKnightMoves = blackKnightMovesService.getMovesToDestinationPosition();
		String[] arrBlackKnightMoves = blackKnightMoves.split(" ");

		KnightMovesResponse knightMovesResponse = new KnightMovesResponse();
		knightMovesResponse.setStatus("Success");

		StringBuilder whiteMoves = new StringBuilder("<br>");

		for (String str : arrWhiteKnightMoves) {
			whiteMoves.append("<span class='btn btn-info' onmouseover=\"highlight('" + str
					+ "');\" onmouseout=\"unhighlight('" + str + "');\">" + str + "</span>&nbsp;");
		}

		knightMovesResponse.setWhiteKnightPath(whiteMoves.toString());

		StringBuilder blackMoves = new StringBuilder("<br>");

		for (String str : arrBlackKnightMoves) {
			blackMoves.append("<span class='btn btn-warning' onmouseover=\"highlight('" + str
					+ "');\" onmouseout=\"unhighlight('" + str + "');\">" + str + "</span>&nbsp;");
		}

		knightMovesResponse.setBlackKnightPath(blackMoves.toString());

		return knightMovesResponse;
	}
}
