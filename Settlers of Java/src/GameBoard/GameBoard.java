/*
*	@file GameBoard.java
*	@author Ryan Niday
*	@date 11-1-16
*	@brief a class used to compile the whole catan game board into a useable state
*/
package GameBoard;

public class GameBoard {
	LineNode[] boardLines;
	public PointNode[] boardPoints;
	PieceNode[] boardPieces;
	
	/* @pre none
	*  @post creates a GameBoard object and initializes all arrays, and sets all array values
	*  @return none
	*/
	public GameBoard(){
		boardLines = new LineNode[72];
		for(int i = 0; i < 72; i++){
			boardLines[i] = new LineNode();
		}
		boardPoints = new PointNode[54];
		for(int i = 0; i < 54; i++){
			boardPoints[i] = new PointNode();
		}
		boardPieces = new PieceNode[19];
		for(int i = 0; i < 19; i++){
			boardPieces[i] = new PieceNode();
		}
		setLineArray();
		setPointArray();
		setPieceArray();
	}
	
	/* @pre none
	*  @post boardLines array has proper values set as corresponding to the board
	*  @return none
	*/
	public void setLineArray(){
		boardLines[0].setAdjacentLines(boardLines[1], boardLines[6], null, null);
		boardLines[0].setAdjacentPoints(boardPoints[0], boardPoints[3]);
		boardLines[0].setAdjacentPieces(boardPieces[0], null);
		boardLines[0].setOccupancy("1");
		boardLines[1].setAdjacentLines(boardLines[0], boardLines[2], boardLines[7], null);
		boardLines[1].setAdjacentPoints(boardPoints[0], boardPoints[4]);
		boardLines[1].setAdjacentPieces(boardPieces[0], null);
		boardLines[1].setOccupancy("2");
		boardLines[2].setAdjacentLines(boardLines[1], boardLines[7], boardLines[3], null);
		boardLines[2].setAdjacentPoints(boardPoints[4], boardPoints[1]);
		boardLines[2].setAdjacentPieces(boardPieces[1], null);
		boardLines[2].setOccupancy("3");
		boardLines[3].setAdjacentLines(boardLines[2], boardLines[8], boardLines[4], null);
		boardLines[3].setAdjacentPoints(boardPoints[1], boardPoints[5]);
		boardLines[3].setAdjacentPieces(boardPieces[1], null);
		boardLines[3].setOccupancy("4");
		boardLines[4].setAdjacentLines(boardLines[3], boardLines[8], boardLines[5], null);
		boardLines[4].setAdjacentPoints(boardPoints[5], boardPoints[2]);
		boardLines[4].setAdjacentPieces(boardPieces[2], null);
		boardLines[4].setOccupancy("5");
		boardLines[5].setAdjacentLines(boardLines[4], boardLines[9], null, null);
		boardLines[5].setAdjacentPoints(boardPoints[2], boardPoints[6]);
		boardLines[5].setAdjacentPieces(boardPieces[2], null);
		boardLines[5].setOccupancy("6");
		boardLines[6].setAdjacentLines(boardLines[0], boardLines[10], boardLines[11], null);
		boardLines[6].setAdjacentPoints(boardPoints[3], boardPoints[7]);
		boardLines[6].setAdjacentPieces(boardPieces[0], null);
		boardLines[6].setOccupancy("7");
		boardLines[7].setAdjacentLines(boardLines[1], boardLines[2], boardLines[12], boardLines[13]);
		boardLines[7].setAdjacentPoints(boardPoints[4], boardPoints[8]);
		boardLines[7].setAdjacentPieces(boardPieces[0], boardPieces[1]);
		boardLines[7].setOccupancy("8");
		boardLines[8].setAdjacentLines(boardLines[3], boardLines[4], boardLines[14], boardLines[15]);
		boardLines[8].setAdjacentPoints(boardPoints[5], boardPoints[9]);
		boardLines[8].setAdjacentPieces(boardPieces[1], boardPieces[2]);
		boardLines[8].setOccupancy("9");
		boardLines[9].setAdjacentLines(boardLines[5], boardLines[16], boardLines[17], null);
		boardLines[9].setAdjacentPoints(boardPoints[6], boardPoints[10]);
		boardLines[9].setAdjacentPieces(boardPieces[2], null);
		boardLines[9].setOccupancy("10");
		boardLines[10].setAdjacentLines(boardLines[6], boardLines[11], boardLines[18], null);
		boardLines[10].setAdjacentPoints(boardPoints[7], boardPoints[11]);
		boardLines[10].setAdjacentPieces(boardPieces[3], null);
		boardLines[10].setOccupancy("11");
		boardLines[11].setAdjacentLines(boardLines[6], boardLines[10], boardLines[12], boardLines[19]);
		boardLines[11].setAdjacentPoints(boardPoints[7], boardPoints[12]);
		boardLines[11].setAdjacentPieces(boardPieces[0], boardPieces[3]);
		boardLines[11].setOccupancy("12");
		boardLines[12].setAdjacentLines(boardLines[7], boardLines[11], boardLines[13], boardLines[19]);
		boardLines[12].setAdjacentPoints(boardPoints[8], boardPoints[12]);
		boardLines[12].setAdjacentPieces(boardPieces[0], boardPieces[4]);
		boardLines[12].setOccupancy("13");
		boardLines[13].setAdjacentLines(boardLines[7], boardLines[12], boardLines[14], boardLines[20]);
		boardLines[13].setAdjacentPoints(boardPoints[8], boardPoints[13]);
		boardLines[13].setAdjacentPieces(boardPieces[1], boardPieces[4]);
		boardLines[13].setOccupancy("14");
		boardLines[14].setAdjacentLines(boardLines[8], boardLines[13], boardLines[15], boardLines[20]);
		boardLines[14].setAdjacentPoints(boardPoints[9], boardPoints[13]);
		boardLines[14].setAdjacentPieces(boardPieces[1], boardPieces[5]);
		boardLines[14].setOccupancy("15");
		boardLines[15].setAdjacentLines(boardLines[8], boardLines[14], boardLines[16], boardLines[21]);
		boardLines[15].setAdjacentPoints(boardPoints[9], boardPoints[14]);
		boardLines[15].setAdjacentPieces(boardPieces[2], boardPieces[5]);
		boardLines[15].setOccupancy("16");
		boardLines[16].setAdjacentLines(boardLines[9], boardLines[15], boardLines[17], boardLines[21]);
		boardLines[16].setAdjacentPoints(boardPoints[10], boardPoints[14]);
		boardLines[16].setAdjacentPieces(boardPieces[2], boardPieces[6]);
		boardLines[16].setOccupancy("17");
		boardLines[17].setAdjacentLines(boardLines[9], boardLines[16], boardLines[22], null);
		boardLines[17].setAdjacentPoints(boardPoints[10], boardPoints[15]);
		boardLines[17].setAdjacentPieces(boardPieces[6], null);
		boardLines[17].setOccupancy("18");
		boardLines[18].setAdjacentLines(boardLines[10], boardLines[23], boardLines[24], null);
		boardLines[18].setAdjacentPoints(boardPoints[11], boardPoints[16]);
		boardLines[18].setAdjacentPieces(boardPieces[3], null);
		boardLines[18].setOccupancy("19");
		boardLines[19].setAdjacentLines(boardLines[11], boardLines[12], boardLines[25], boardLines[26]);
		boardLines[19].setAdjacentPoints(boardPoints[12], boardPoints[17]);
		boardLines[19].setAdjacentPieces(boardPieces[3], boardPieces[4]);
		boardLines[19].setOccupancy("20");
		boardLines[20].setAdjacentLines(boardLines[13], boardLines[14], boardLines[27], boardLines[28]);
		boardLines[20].setAdjacentPoints(boardPoints[13], boardPoints[18]);
		boardLines[20].setAdjacentPieces(boardPieces[4], boardPieces[5]);
		boardLines[20].setOccupancy("21");
		boardLines[21].setAdjacentLines(boardLines[15], boardLines[16], boardLines[29], boardLines[30]);
		boardLines[21].setAdjacentPoints(boardPoints[14], boardPoints[19]);
		boardLines[21].setAdjacentPieces(boardPieces[5], boardPieces[6]);
		boardLines[21].setOccupancy("22");
		boardLines[22].setAdjacentLines(boardLines[17], boardLines[31], boardLines[32], null);
		boardLines[22].setAdjacentPoints(boardPoints[15], boardPoints[20]);
		boardLines[22].setAdjacentPieces(boardPieces[6], null);
		boardLines[22].setOccupancy("23");
		boardLines[23].setAdjacentLines(boardLines[18], boardLines[24], boardLines[33], null);
		boardLines[23].setAdjacentPoints(boardPoints[16], boardPoints[21]);
		boardLines[23].setAdjacentPieces(boardPieces[7], null);
		boardLines[23].setOccupancy("24");
		boardLines[24].setAdjacentLines(boardLines[18], boardLines[23], boardLines[25], boardLines[34]);
		boardLines[24].setAdjacentPoints(boardPoints[16], boardPoints[22]);
		boardLines[24].setAdjacentPieces(boardPieces[3], boardPieces[7]);
		boardLines[24].setOccupancy("25");
		boardLines[25].setAdjacentLines(boardLines[19], boardLines[24], boardLines[26], boardLines[34]);
		boardLines[25].setAdjacentPoints(boardPoints[17], boardPoints[22]);
		boardLines[25].setAdjacentPieces(boardPieces[3], boardPieces[8]);
		boardLines[25].setOccupancy("26");
		boardLines[26].setAdjacentLines(boardLines[19], boardLines[25], boardLines[27], boardLines[35]);
		boardLines[26].setAdjacentPoints(boardPoints[17], boardPoints[23]);
		boardLines[26].setAdjacentPieces(boardPieces[4], boardPieces[8]);
		boardLines[26].setOccupancy("27");
		boardLines[27].setAdjacentLines(boardLines[20], boardLines[26], boardLines[28], boardLines[35]);
		boardLines[27].setAdjacentPoints(boardPoints[18], boardPoints[23]);
		boardLines[27].setAdjacentPieces(boardPieces[4], boardPieces[9]);
		boardLines[27].setOccupancy("28");
		boardLines[28].setAdjacentLines(boardLines[20], boardLines[27], boardLines[29], boardLines[36]);
		boardLines[28].setAdjacentPoints(boardPoints[18], boardPoints[24]);
		boardLines[28].setAdjacentPieces(boardPieces[5], boardPieces[9]);
		boardLines[28].setOccupancy("29");
		boardLines[29].setAdjacentLines(boardLines[21], boardLines[28], boardLines[30], boardLines[36]);
		boardLines[29].setAdjacentPoints(boardPoints[19], boardPoints[24]);
		boardLines[29].setAdjacentPieces(boardPieces[5], boardPieces[10]);
		boardLines[29].setOccupancy("30");
		boardLines[30].setAdjacentLines(boardLines[21], boardLines[29], boardLines[31], boardLines[37]);
		boardLines[30].setAdjacentPoints(boardPoints[19], boardPoints[25]);
		boardLines[30].setAdjacentPieces(boardPieces[6], boardPieces[10]);
		boardLines[30].setOccupancy("31");
		boardLines[31].setAdjacentLines(boardLines[22], boardLines[30], boardLines[32], boardLines[37]);
		boardLines[31].setAdjacentPoints(boardPoints[20], boardPoints[25]);
		boardLines[31].setAdjacentPieces(boardPieces[6], boardPieces[11]);
		boardLines[31].setOccupancy("32");
		boardLines[32].setAdjacentLines(boardLines[22], boardLines[31], boardLines[38], null);
		boardLines[32].setAdjacentPoints(boardPoints[20], boardPoints[26]);
		boardLines[32].setAdjacentPieces(boardPieces[11], null);
		boardLines[32].setOccupancy("33");
		boardLines[33].setAdjacentLines(boardLines[23], boardLines[39], null, null);
		boardLines[33].setAdjacentPoints(boardPoints[21], boardPoints[27]);
		boardLines[33].setAdjacentPieces(boardPieces[7], null);
		boardLines[33].setOccupancy("34");
		boardLines[34].setAdjacentLines(boardLines[24], boardLines[25], boardLines[40], boardLines[41]);
		boardLines[34].setAdjacentPoints(boardPoints[22], boardPoints[28]);
		boardLines[34].setAdjacentPieces(boardPieces[7], boardPieces[8]);
		boardLines[34].setOccupancy("35");
		boardLines[35].setAdjacentLines(boardLines[26], boardLines[27], boardLines[42], boardLines[43]);
		boardLines[35].setAdjacentPoints(boardPoints[23], boardPoints[29]);
		boardLines[35].setAdjacentPieces(boardPieces[8], boardPieces[9]);
		boardLines[35].setOccupancy("36");
		boardLines[36].setAdjacentLines(boardLines[28], boardLines[29], boardLines[44], boardLines[45]);
		boardLines[36].setAdjacentPoints(boardPoints[24], boardPoints[30]);
		boardLines[36].setAdjacentPieces(boardPieces[9], boardPieces[10]);
		boardLines[36].setOccupancy("37");
		boardLines[37].setAdjacentLines(boardLines[30], boardLines[31], boardLines[46], boardLines[47]);
		boardLines[37].setAdjacentPoints(boardPoints[25], boardPoints[31]);
		boardLines[37].setAdjacentPieces(boardPieces[10], boardPieces[11]);
		boardLines[37].setOccupancy("38");
		boardLines[38].setAdjacentLines(boardLines[32], boardLines[48], null, null);
		boardLines[38].setAdjacentPoints(boardPoints[26], boardPoints[32]);
		boardLines[38].setAdjacentPieces(boardPieces[11], null);
		boardLines[38].setOccupancy("39");
		boardLines[39].setAdjacentLines(boardLines[33], boardLines[40], boardLines[49], null);
		boardLines[39].setAdjacentPoints(boardPoints[27], boardPoints[33]);
		boardLines[39].setAdjacentPieces(boardPieces[7], null);
		boardLines[39].setOccupancy("40");
		boardLines[40].setAdjacentLines(boardLines[34], boardLines[39], boardLines[41], boardLines[49]);
		boardLines[40].setAdjacentPoints(boardPoints[28], boardPoints[33]);
		boardLines[40].setAdjacentPieces(boardPieces[7], boardPieces[12]);
		boardLines[40].setOccupancy("41");
		boardLines[41].setAdjacentLines(boardLines[34], boardLines[40], boardLines[42], boardLines[50]);
		boardLines[41].setAdjacentPoints(boardPoints[28], boardPoints[34]);
		boardLines[41].setAdjacentPieces(boardPieces[8], boardPieces[12]);
		boardLines[41].setOccupancy("42");
		boardLines[42].setAdjacentLines(boardLines[35], boardLines[41], boardLines[43], boardLines[50]);
		boardLines[42].setAdjacentPoints(boardPoints[29], boardPoints[34]);
		boardLines[42].setAdjacentPieces(boardPieces[8], boardPieces[13]);
		boardLines[42].setOccupancy("43");
		boardLines[43].setAdjacentLines(boardLines[35], boardLines[42], boardLines[44], boardLines[51]);
		boardLines[43].setAdjacentPoints(boardPoints[29], boardPoints[35]);
		boardLines[43].setAdjacentPieces(boardPieces[9], boardPieces[13]);
		boardLines[43].setOccupancy("44");
		boardLines[44].setAdjacentLines(boardLines[36], boardLines[43], boardLines[45], boardLines[51]);
		boardLines[44].setAdjacentPoints(boardPoints[30], boardPoints[35]);
		boardLines[44].setAdjacentPieces(boardPieces[9], boardPieces[14]);
		boardLines[44].setOccupancy("45");
		boardLines[45].setAdjacentLines(boardLines[36], boardLines[44], boardLines[46], boardLines[52]);
		boardLines[45].setAdjacentPoints(boardPoints[30], boardPoints[36]);
		boardLines[45].setAdjacentPieces(boardPieces[10], boardPieces[14]);
		boardLines[45].setOccupancy("46");
		boardLines[46].setAdjacentLines(boardLines[37], boardLines[45], boardLines[47], boardLines[52]);
		boardLines[46].setAdjacentPoints(boardPoints[31], boardPoints[36]);
		boardLines[46].setAdjacentPieces(boardPieces[10], boardPieces[15]);
		boardLines[46].setOccupancy("47");
		boardLines[47].setAdjacentLines(boardLines[37], boardLines[36], boardLines[48], boardLines[53]);
		boardLines[47].setAdjacentPoints(boardPoints[31], boardPoints[37]);
		boardLines[47].setAdjacentPieces(boardPieces[11], boardPieces[15]);
		boardLines[47].setOccupancy("48");
		boardLines[48].setAdjacentLines(boardLines[38], boardLines[47], boardLines[53], null);
		boardLines[48].setAdjacentPoints(boardPoints[32], boardPoints[37]);
		boardLines[48].setAdjacentPieces(boardPieces[11], null);
		boardLines[48].setOccupancy("49");
		boardLines[49].setAdjacentLines(boardLines[39], boardLines[40], boardLines[54], null);
		boardLines[49].setAdjacentPoints(boardPoints[33], boardPoints[38]);
		boardLines[49].setAdjacentPieces(boardPieces[12], null);
		boardLines[49].setOccupancy("50");
		boardLines[50].setAdjacentLines(boardLines[41], boardLines[42], boardLines[55], boardLines[56]);
		boardLines[50].setAdjacentPoints(boardPoints[34], boardPoints[39]);
		boardLines[50].setAdjacentPieces(boardPieces[12], boardPieces[13]);
		boardLines[50].setOccupancy("51");
		boardLines[51].setAdjacentLines(boardLines[43], boardLines[44], boardLines[57], boardLines[58]);
		boardLines[51].setAdjacentPoints(boardPoints[35], boardPoints[40]);
		boardLines[51].setAdjacentPieces(boardPieces[13], boardPieces[14]);
		boardLines[51].setOccupancy("52");
		boardLines[52].setAdjacentLines(boardLines[45], boardLines[46], boardLines[59], boardLines[60]);
		boardLines[52].setAdjacentPoints(boardPoints[36], boardPoints[41]);
		boardLines[52].setAdjacentPieces(boardPieces[14], boardPieces[15]);
		boardLines[52].setOccupancy("53");
		boardLines[53].setAdjacentLines(boardLines[47], boardLines[48], boardLines[61], null);
		boardLines[53].setAdjacentPoints(boardPoints[37], boardPoints[42]);
		boardLines[53].setAdjacentPieces(boardPieces[15], null);
		boardLines[53].setOccupancy("54");
		boardLines[54].setAdjacentLines(boardLines[49], boardLines[55], boardLines[62], null);
		boardLines[54].setAdjacentPoints(boardPoints[38], boardPoints[43]);
		boardLines[54].setAdjacentPieces(boardPieces[12], null);
		boardLines[54].setOccupancy("55");
		boardLines[55].setAdjacentLines(boardLines[50], boardLines[54], boardLines[56], boardLines[62]);
		boardLines[55].setAdjacentPoints(boardPoints[39], boardPoints[43]);
		boardLines[55].setAdjacentPieces(boardPieces[12], boardPieces[16]);
		boardLines[55].setOccupancy("56");
		boardLines[56].setAdjacentLines(boardLines[50], boardLines[55], boardLines[57], boardLines[63]);
		boardLines[56].setAdjacentPoints(boardPoints[39], boardPoints[44]);
		boardLines[56].setAdjacentPieces(boardPieces[13], boardPieces[16]);
		boardLines[56].setOccupancy("57");
		boardLines[57].setAdjacentLines(boardLines[51], boardLines[56], boardLines[58], boardLines[63]);
		boardLines[57].setAdjacentPoints(boardPoints[40], boardPoints[44]);
		boardLines[57].setAdjacentPieces(boardPieces[13], boardPieces[17]);
		boardLines[57].setOccupancy("58");
		boardLines[58].setAdjacentLines(boardLines[51], boardLines[57], boardLines[59], boardLines[64]);
		boardLines[58].setAdjacentPoints(boardPoints[40], boardPoints[45]);
		boardLines[58].setAdjacentPieces(boardPieces[14], boardPieces[17]);
		boardLines[58].setOccupancy("59");
		boardLines[59].setAdjacentLines(boardLines[52], boardLines[58], boardLines[60], boardLines[64]);
		boardLines[59].setAdjacentPoints(boardPoints[41], boardPoints[45]);
		boardLines[59].setAdjacentPieces(boardPieces[14], boardPieces[18]);
		boardLines[59].setOccupancy("60");
		boardLines[60].setAdjacentLines(boardLines[52], boardLines[59], boardLines[61], boardLines[65]);
		boardLines[60].setAdjacentPoints(boardPoints[41], boardPoints[46]);
		boardLines[60].setAdjacentPieces(boardPieces[15], boardPieces[18]);
		boardLines[60].setOccupancy("61");
		boardLines[61].setAdjacentLines(boardLines[53], boardLines[60], boardLines[65], null);
		boardLines[61].setAdjacentPoints(boardPoints[42], boardPoints[46]);
		boardLines[61].setAdjacentPieces(boardPieces[15], null);
		boardLines[61].setOccupancy("62");
		boardLines[62].setAdjacentLines(boardLines[54], boardLines[55], boardLines[66], null);
		boardLines[62].setAdjacentPoints(boardPoints[43], boardPoints[47]);
		boardLines[62].setAdjacentPieces(boardPieces[16], null);
		boardLines[62].setOccupancy("63");
		boardLines[63].setAdjacentLines(boardLines[56], boardLines[57], boardLines[67], boardLines[68]);
		boardLines[63].setAdjacentPoints(boardPoints[44], boardPoints[48]);
		boardLines[63].setAdjacentPieces(boardPieces[16], boardPieces[17]);
		boardLines[63].setOccupancy("64");
		boardLines[64].setAdjacentLines(boardLines[58], boardLines[59], boardLines[69], boardLines[70]);
		boardLines[64].setAdjacentPoints(boardPoints[45], boardPoints[49]);
		boardLines[64].setAdjacentPieces(boardPieces[17], boardPieces[18]);
		boardLines[64].setOccupancy("65");
		boardLines[65].setAdjacentLines(boardLines[60], boardLines[61], boardLines[71], null);
		boardLines[65].setAdjacentPoints(boardPoints[46], boardPoints[50]);
		boardLines[65].setAdjacentPieces(boardPieces[18], null);
		boardLines[65].setOccupancy("66");
		boardLines[66].setAdjacentLines(boardLines[62], boardLines[67], null, null);
		boardLines[66].setAdjacentPoints(boardPoints[47], boardPoints[51]);
		boardLines[66].setAdjacentPieces(boardPieces[16], null);
		boardLines[66].setOccupancy("67");
		boardLines[67].setAdjacentLines(boardLines[63], boardLines[66], boardLines[68], null);
		boardLines[67].setAdjacentPoints(boardPoints[48], boardPoints[51]);
		boardLines[67].setAdjacentPieces(boardPieces[16], null);
		boardLines[67].setOccupancy("68");
		boardLines[68].setAdjacentLines(boardLines[63], boardLines[67], boardLines[69], null);
		boardLines[68].setAdjacentPoints(boardPoints[48], boardPoints[52]);
		boardLines[68].setAdjacentPieces(boardPieces[17], null);
		boardLines[68].setOccupancy("69");
		boardLines[69].setAdjacentLines(boardLines[64], boardLines[68], boardLines[70], null);
		boardLines[69].setAdjacentPoints(boardPoints[49], boardPoints[52]);
		boardLines[69].setAdjacentPieces(boardPieces[17], null);
		boardLines[69].setOccupancy("70");
		boardLines[70].setAdjacentLines(boardLines[64], boardLines[69], boardLines[71], null);
		boardLines[70].setAdjacentPoints(boardPoints[49], boardPoints[53]);
		boardLines[70].setAdjacentPieces(boardPieces[18], null);
		boardLines[70].setOccupancy("71");
		boardLines[71].setAdjacentLines(boardLines[65], boardLines[70], null, null);
		boardLines[71].setAdjacentPoints(boardPoints[50], boardPoints[53]);
		boardLines[71].setAdjacentPieces(boardPieces[18], null);
		boardLines[71].setOccupancy("72");
	}
	
	/* @pre none
	*  @post boardPoints array has proper values set as corresponding to the board
	*  @return none
	*/
	public void setPointArray(){
		boardPoints[0].setAdjacentLines(boardLines[0], boardLines[1], null);
		boardPoints[0].setAdjacentPoints(boardPoints[3], boardPoints[4], null);
		boardPoints[0].setAdjacentPieces(boardPieces[0], null, null);
		boardPoints[0].setOccupancy("1");
		boardPoints[1].setAdjacentLines(boardLines[2], boardLines[3], null);
		boardPoints[1].setAdjacentPoints(boardPoints[4], boardPoints[5], null);
		boardPoints[1].setAdjacentPieces(boardPieces[1], null, null);
		boardPoints[1].setOccupancy("2");
		boardPoints[2].setAdjacentLines(boardLines[4], boardLines[5], null);
		boardPoints[2].setAdjacentPoints(boardPoints[4], boardPoints[5], null);
		boardPoints[2].setAdjacentPieces(boardPieces[2], null, null);
		boardPoints[2].setOccupancy("3");
		boardPoints[3].setAdjacentLines(boardLines[0], boardLines[6], null);
		boardPoints[3].setAdjacentPoints(boardPoints[0], boardPoints[7], null);
		boardPoints[3].setAdjacentPieces(boardPieces[0], null, null);
		boardPoints[3].setOccupancy("4");
		boardPoints[4].setAdjacentLines(boardLines[1], boardLines[2], boardLines[7]);
		boardPoints[4].setAdjacentPoints(boardPoints[0], boardPoints[1], boardPoints[8]);
		boardPoints[4].setAdjacentPieces(boardPieces[0], boardPieces[1], null);
		boardPoints[4].setOccupancy("5");
		boardPoints[5].setAdjacentLines(boardLines[3], boardLines[4], boardLines[8]);
		boardPoints[5].setAdjacentPoints(boardPoints[1], boardPoints[2], boardPoints[9]);
		boardPoints[5].setAdjacentPieces(boardPieces[1], boardPieces[2], null);
		boardPoints[5].setOccupancy("6");
		boardPoints[6].setAdjacentLines(boardLines[5], boardLines[9], null);
		boardPoints[6].setAdjacentPoints(boardPoints[2], boardPoints[10], null);
		boardPoints[6].setAdjacentPieces(boardPieces[2], null, null);
		boardPoints[6].setOccupancy("7");
		boardPoints[7].setAdjacentLines(boardLines[6], boardLines[10], boardLines[11]);
		boardPoints[7].setAdjacentPoints(boardPoints[3], boardPoints[11], boardPoints[12]);
		boardPoints[7].setAdjacentPieces(boardPieces[0], boardPieces[3], null);
		boardPoints[7].setOccupancy("8");
		boardPoints[8].setAdjacentLines(boardLines[7], boardLines[12], boardLines[13]);
		boardPoints[8].setAdjacentPoints(boardPoints[4], boardPoints[12], boardPoints[13]);
		boardPoints[8].setAdjacentPieces(boardPieces[0], boardPieces[1], boardPieces[4]);
		boardPoints[8].setOccupancy("9");
		boardPoints[9].setAdjacentLines(boardLines[8], boardLines[14], boardLines[15]);
		boardPoints[9].setAdjacentPoints(boardPoints[5], boardPoints[13], boardPoints[14]);
		boardPoints[9].setAdjacentPieces(boardPieces[1], boardPieces[2], boardPieces[5]);
		boardPoints[9].setOccupancy("10");
		boardPoints[10].setAdjacentLines(boardLines[9], boardLines[16], boardLines[17]);
		boardPoints[10].setAdjacentPoints(boardPoints[6], boardPoints[14], boardPoints[15]);
		boardPoints[10].setAdjacentPieces(boardPieces[2], boardPieces[6], null);
		boardPoints[10].setOccupancy("11");
		boardPoints[11].setAdjacentLines(boardLines[10], boardLines[18], null);
		boardPoints[11].setAdjacentPoints(boardPoints[7], boardPoints[16], null);
		boardPoints[11].setAdjacentPieces(boardPieces[3], null, null);
		boardPoints[11].setOccupancy("12");
		boardPoints[12].setAdjacentLines(boardLines[11], boardLines[12], boardLines[19]);
		boardPoints[12].setAdjacentPoints(boardPoints[7], boardPoints[8], boardPoints[17]);
		boardPoints[12].setAdjacentPieces(boardPieces[0], boardPieces[3], boardPieces[4]);
		boardPoints[12].setOccupancy("13");
		boardPoints[13].setAdjacentLines(boardLines[13], boardLines[14], boardLines[20]);
		boardPoints[13].setAdjacentPoints(boardPoints[8], boardPoints[9], boardPoints[18]);
		boardPoints[13].setAdjacentPieces(boardPieces[1], boardPieces[4], boardPieces[5]);
		boardPoints[13].setOccupancy("14");
		boardPoints[14].setAdjacentLines(boardLines[15], boardLines[16], boardLines[21]);
		boardPoints[14].setAdjacentPoints(boardPoints[9], boardPoints[10], boardPoints[19]);
		boardPoints[14].setAdjacentPieces(boardPieces[2], boardPieces[5], boardPieces[6]);
		boardPoints[14].setOccupancy("15");
		boardPoints[15].setAdjacentLines(boardLines[17], boardLines[22], null);
		boardPoints[15].setAdjacentPoints(boardPoints[10], boardPoints[20], null);
		boardPoints[15].setAdjacentPieces(boardPieces[6], null, null);
		boardPoints[15].setOccupancy("16");
		boardPoints[16].setAdjacentLines(boardLines[18], boardLines[23], boardLines[24]);
		boardPoints[16].setAdjacentPoints(boardPoints[11], boardPoints[21], boardPoints[22]);
		boardPoints[16].setAdjacentPieces(boardPieces[3], boardPieces[7], null);
		boardPoints[16].setOccupancy("17");
		boardPoints[17].setAdjacentLines(boardLines[19], boardLines[25], boardLines[26]);
		boardPoints[17].setAdjacentPoints(boardPoints[12], boardPoints[22], boardPoints[23]);
		boardPoints[17].setAdjacentPieces(boardPieces[3], boardPieces[4], boardPieces[8]);
		boardPoints[17].setOccupancy("18");
		boardPoints[18].setAdjacentLines(boardLines[20], boardLines[27], boardLines[28]);
		boardPoints[18].setAdjacentPoints(boardPoints[13], boardPoints[23], boardPoints[24]);
		boardPoints[18].setAdjacentPieces(boardPieces[4], boardPieces[5], boardPieces[9]);
		boardPoints[18].setOccupancy("19");
		boardPoints[19].setAdjacentLines(boardLines[20], boardLines[29], boardLines[30]);
		boardPoints[19].setAdjacentPoints(boardPoints[14], boardPoints[24], boardPoints[25]);
		boardPoints[19].setAdjacentPieces(boardPieces[5], boardPieces[6], boardPieces[10]);
		boardPoints[19].setOccupancy("20");
		boardPoints[20].setAdjacentLines(boardLines[21], boardLines[31], boardLines[32]);
		boardPoints[20].setAdjacentPoints(boardPoints[15], boardPoints[25], boardPoints[26]);
		boardPoints[20].setAdjacentPieces(boardPieces[6], boardPieces[11], null);
		boardPoints[20].setOccupancy("21");
		boardPoints[21].setAdjacentLines(boardLines[23], boardLines[33], null);
		boardPoints[21].setAdjacentPoints(boardPoints[16], boardPoints[27], null);
		boardPoints[21].setAdjacentPieces(boardPieces[7], null, null);
		boardPoints[21].setOccupancy("22");
		boardPoints[22].setAdjacentLines(boardLines[24], boardLines[25], boardLines[34]);
		boardPoints[22].setAdjacentPoints(boardPoints[16], boardPoints[17], boardPoints[28]);
		boardPoints[22].setAdjacentPieces(boardPieces[3], boardPieces[7], boardPieces[8]);
		boardPoints[22].setOccupancy("23");
		boardPoints[23].setAdjacentLines(boardLines[26], boardLines[27], boardLines[35]);
		boardPoints[23].setAdjacentPoints(boardPoints[17], boardPoints[18], boardPoints[29]);
		boardPoints[23].setAdjacentPieces(boardPieces[4], boardPieces[8], boardPieces[9]);
		boardPoints[23].setOccupancy("24");
		boardPoints[24].setAdjacentLines(boardLines[28], boardLines[29], boardLines[36]);
		boardPoints[24].setAdjacentPoints(boardPoints[18], boardPoints[19], boardPoints[30]);
		boardPoints[24].setAdjacentPieces(boardPieces[5], boardPieces[9], boardPieces[10]);
		boardPoints[24].setOccupancy("25");
		boardPoints[25].setAdjacentLines(boardLines[30], boardLines[31], boardLines[37]);
		boardPoints[25].setAdjacentPoints(boardPoints[19], boardPoints[20], boardPoints[31]);
		boardPoints[25].setAdjacentPieces(boardPieces[6], boardPieces[10], boardPieces[11]);
		boardPoints[25].setOccupancy("26");
		boardPoints[26].setAdjacentLines(boardLines[32], boardLines[38], null);
		boardPoints[26].setAdjacentPoints(boardPoints[20], boardPoints[32], null);
		boardPoints[26].setAdjacentPieces(boardPieces[11], null, null);
		boardPoints[26].setOccupancy("27");
		boardPoints[27].setAdjacentLines(boardLines[33], boardLines[39], null);
		boardPoints[27].setAdjacentPoints(boardPoints[21], boardPoints[33], null);
		boardPoints[27].setAdjacentPieces(boardPieces[7], null, null);
		boardPoints[27].setOccupancy("28");
		boardPoints[28].setAdjacentLines(boardLines[34], boardLines[40], boardLines[41]);
		boardPoints[28].setAdjacentPoints(boardPoints[22], boardPoints[33], boardPoints[34]);
		boardPoints[28].setAdjacentPieces(boardPieces[7], boardPieces[8], boardPieces[12]);
		boardPoints[28].setOccupancy("29");
		boardPoints[29].setAdjacentLines(boardLines[35], boardLines[42], boardLines[43]);
		boardPoints[29].setAdjacentPoints(boardPoints[23], boardPoints[34], boardPoints[35]);
		boardPoints[29].setAdjacentPieces(boardPieces[8], boardPieces[9], boardPieces[13]);
		boardPoints[29].setOccupancy("30");
		boardPoints[30].setAdjacentLines(boardLines[36], boardLines[44], boardLines[45]);
		boardPoints[30].setAdjacentPoints(boardPoints[24], boardPoints[35], boardPoints[36]);
		boardPoints[30].setAdjacentPieces(boardPieces[9], boardPieces[10], boardPieces[14]);
		boardPoints[30].setOccupancy("31");
		boardPoints[31].setAdjacentLines(boardLines[37], boardLines[46], boardLines[47]);
		boardPoints[31].setAdjacentPoints(boardPoints[25], boardPoints[36], boardPoints[37]);
		boardPoints[31].setAdjacentPieces(boardPieces[10], boardPieces[11], boardPieces[15]);
		boardPoints[31].setOccupancy("32");
		boardPoints[32].setAdjacentLines(boardLines[38], boardLines[48], null);
		boardPoints[32].setAdjacentPoints(boardPoints[26], boardPoints[37], null);
		boardPoints[32].setAdjacentPieces(boardPieces[11], null, null);
		boardPoints[32].setOccupancy("33");
		boardPoints[33].setAdjacentLines(boardLines[39], boardLines[40], boardLines[49]);
		boardPoints[33].setAdjacentPoints(boardPoints[27], boardPoints[28], boardPoints[38]);
		boardPoints[33].setAdjacentPieces(boardPieces[7], boardPieces[12], null);
		boardPoints[33].setOccupancy("34");
		boardPoints[34].setAdjacentLines(boardLines[41], boardLines[42], boardLines[50]);
		boardPoints[34].setAdjacentPoints(boardPoints[28], boardPoints[29], boardPoints[39]);
		boardPoints[34].setAdjacentPieces(boardPieces[8], boardPieces[12], boardPieces[13]);
		boardPoints[34].setOccupancy("35");
		boardPoints[35].setAdjacentLines(boardLines[43], boardLines[44], boardLines[51]);
		boardPoints[35].setAdjacentPoints(boardPoints[29], boardPoints[30], boardPoints[40]);
		boardPoints[35].setAdjacentPieces(boardPieces[9], boardPieces[13], boardPieces[14]);
		boardPoints[35].setOccupancy("36");
		boardPoints[36].setAdjacentLines(boardLines[45], boardLines[46], boardLines[52]);
		boardPoints[36].setAdjacentPoints(boardPoints[30], boardPoints[31], boardPoints[41]);
		boardPoints[36].setAdjacentPieces(boardPieces[10], boardPieces[14], boardPieces[15]);
		boardPoints[36].setOccupancy("37");
		boardPoints[37].setAdjacentLines(boardLines[47], boardLines[48], boardLines[53]);
		boardPoints[37].setAdjacentPoints(boardPoints[31], boardPoints[32], boardPoints[42]);
		boardPoints[37].setAdjacentPieces(boardPieces[11], boardPieces[15], null);
		boardPoints[37].setOccupancy("38");
		boardPoints[38].setAdjacentLines(boardLines[49], boardLines[54], null);
		boardPoints[38].setAdjacentPoints(boardPoints[33], boardPoints[43], null);
		boardPoints[38].setAdjacentPieces(boardPieces[12], null, null);
		boardPoints[38].setOccupancy("39");
		boardPoints[39].setAdjacentLines(boardLines[50], boardLines[55], boardLines[56]);
		boardPoints[39].setAdjacentPoints(boardPoints[34], boardPoints[43], boardPoints[44]);
		boardPoints[39].setAdjacentPieces(boardPieces[12], boardPieces[13], boardPieces[16]);
		boardPoints[39].setOccupancy("40");
		boardPoints[40].setAdjacentLines(boardLines[51], boardLines[57], boardLines[58]);
		boardPoints[40].setAdjacentPoints(boardPoints[35], boardPoints[44], boardPoints[45]);
		boardPoints[40].setAdjacentPieces(boardPieces[13], boardPieces[14], boardPieces[17]);
		boardPoints[40].setOccupancy("41");
		boardPoints[41].setAdjacentLines(boardLines[52], boardLines[59], boardLines[60]);
		boardPoints[41].setAdjacentPoints(boardPoints[36], boardPoints[45], boardPoints[46]);
		boardPoints[41].setAdjacentPieces(boardPieces[14], boardPieces[15], boardPieces[18]);
		boardPoints[41].setOccupancy("42");
		boardPoints[42].setAdjacentLines(boardLines[53], boardLines[61], null);
		boardPoints[42].setAdjacentPoints(boardPoints[37], boardPoints[46], null);
		boardPoints[42].setAdjacentPieces(boardPieces[17], null, null);
		boardPoints[42].setOccupancy("43");
		boardPoints[43].setAdjacentLines(boardLines[54], boardLines[55], boardLines[62]);
		boardPoints[43].setAdjacentPoints(boardPoints[38], boardPoints[39], boardPoints[47]);
		boardPoints[43].setAdjacentPieces(boardPieces[12], boardPieces[16], null);
		boardPoints[43].setOccupancy("44");
		boardPoints[44].setAdjacentLines(boardLines[56], boardLines[57], boardLines[63]);
		boardPoints[44].setAdjacentPoints(boardPoints[39], boardPoints[40], boardPoints[48]);
		boardPoints[44].setAdjacentPieces(boardPieces[13], boardPieces[16], boardPieces[17]);
		boardPoints[44].setOccupancy("45");
		boardPoints[45].setAdjacentLines(boardLines[58], boardLines[59], boardLines[64]);
		boardPoints[45].setAdjacentPoints(boardPoints[40], boardPoints[41], boardPoints[49]);
		boardPoints[45].setAdjacentPieces(boardPieces[14], boardPieces[17], boardPieces[18]);
		boardPoints[45].setOccupancy("46");
		boardPoints[46].setAdjacentLines(boardLines[60], boardLines[61], boardLines[65]);
		boardPoints[46].setAdjacentPoints(boardPoints[41], boardPoints[42], boardPoints[50]);
		boardPoints[46].setAdjacentPieces(boardPieces[15], boardPieces[18], null);
		boardPoints[46].setOccupancy("47");
		boardPoints[47].setAdjacentLines(boardLines[62], boardLines[66], null);
		boardPoints[47].setAdjacentPoints(boardPoints[43], boardPoints[51], null);
		boardPoints[47].setAdjacentPieces(boardPieces[16], null, null);
		boardPoints[47].setOccupancy("48");
		boardPoints[48].setAdjacentLines(boardLines[63], boardLines[67], boardLines[68]);
		boardPoints[48].setAdjacentPoints(boardPoints[44], boardPoints[51], boardPoints[52]);
		boardPoints[48].setAdjacentPieces(boardPieces[16], boardPieces[17], null);
		boardPoints[48].setOccupancy("49");
		boardPoints[49].setAdjacentLines(boardLines[64], boardLines[69], boardLines[70]);
		boardPoints[49].setAdjacentPoints(boardPoints[45], boardPoints[52], boardPoints[53]);
		boardPoints[49].setAdjacentPieces(boardPieces[17], boardPieces[18], null);
		boardPoints[49].setOccupancy("50");
		boardPoints[50].setAdjacentLines(boardLines[65], boardLines[71], null);
		boardPoints[50].setAdjacentPoints(boardPoints[46], boardPoints[53], null);
		boardPoints[50].setAdjacentPieces(boardPieces[18], null, null);
		boardPoints[50].setOccupancy("51");
		boardPoints[51].setAdjacentLines(boardLines[66], boardLines[67], null);
		boardPoints[51].setAdjacentPoints(boardPoints[47], boardPoints[48], null);
		boardPoints[51].setAdjacentPieces(boardPieces[16], null, null);
		boardPoints[51].setOccupancy("52");
		boardPoints[52].setAdjacentLines(boardLines[68], boardLines[69], null);
		boardPoints[52].setAdjacentPoints(boardPoints[48], boardPoints[49], null);
		boardPoints[52].setAdjacentPieces(boardPieces[17], null, null);
		boardPoints[52].setOccupancy("53");
		boardPoints[53].setAdjacentLines(boardLines[70], boardLines[71], null);
		boardPoints[53].setAdjacentPoints(boardPoints[49], boardPoints[50], null);
		boardPoints[53].setAdjacentPieces(boardPieces[18], null, null);
		boardPoints[53].setOccupancy("54");
	}
	
	/* @pre none
	*  @post boardPieces array has proper values set as corresponding to the board
	*  @return none
	*/
	public void setPieceArray(){
		for(int i = 0; i < 19; i++){
			boardPieces[i].setNumber(i+1);
		}
		int[] resourcesArr = new int[19];
		for(int i = 0; i < 19; i++){
			if(i < 1){
				resourcesArr[i] = 0;
				boardPieces[i].setTileResource(resourcesArr[i]);
			}
			else if(i < 5 && i > 0){
				resourcesArr[i] = 1;
				boardPieces[i].setTileResource(resourcesArr[i]);
			}
			else if(i < 9 && i > 4){
				resourcesArr[i] = 2;
				boardPieces[i].setTileResource(resourcesArr[i]);
			}
			else if(i < 13 && i > 8){
				resourcesArr[i] = 3;
				boardPieces[i].setTileResource(resourcesArr[i]);
			}
			else if(i < 16 && i > 12){
				resourcesArr[i] = 4;
				boardPieces[i].setTileResource(resourcesArr[i]);
			}
			else{
				resourcesArr[i] = 5;
				boardPieces[i].setTileResource(resourcesArr[i]);
			}
		}
		int[] dieArr = new int[19];
		for(int i = 0; i < 19; i++){
			if(i == 0){
				dieArr[i] = 0;
				boardPieces[i].setTileID(dieArr[i]);
			}
			else if(i == 1){
				dieArr[i] = 2;
				boardPieces[i].setTileID(dieArr[i]);
			}
			else if(i == 2 || i == 3){
				dieArr[i] = 3;
				boardPieces[i].setTileID(dieArr[i]);
			}
			else if(i == 4 || i == 5){
				dieArr[i] = 4;
				boardPieces[i].setTileID(dieArr[i]);
			}
			else if(i == 6 || i == 7){
				dieArr[i] = 5;
				boardPieces[i].setTileID(dieArr[i]);
			}
			else if(i == 8 || i == 9){
				dieArr[i] = 6;
				boardPieces[i].setTileID(dieArr[i]);
			}else if(i == 10 || i == 11){
				dieArr[i] = 8;
				boardPieces[i].setTileID(dieArr[i]);
			}
			else if(i == 12 || i == 13){
				dieArr[i] = 9;
				boardPieces[i].setTileID(dieArr[i]);
			}
			else if(i == 14 || i == 15){
				dieArr[i] = 10;
				boardPieces[i].setTileID(dieArr[i]);
			}
			else if(i == 16 || i == 17){
				dieArr[i] = 11;
				boardPieces[i].setTileID(dieArr[i]);
			}
			else{
				dieArr[i] = 12;
				boardPieces[i].setTileID(dieArr[i]);
			}
		}
	}
	
	/* @pre i is valid int
	*  @post none
	*  @return boardPionts array of element i
	*/
	public PointNode getPoint(int i){
		return boardPoints[i];
	}
	
	/* @pre i is valid int
	*  @post none
	*  @return boardLines array of element i
	*/
	public LineNode getLine(int i){
		return boardLines[i];
	}
	
	public LineNode[] getLineArray(){
		return boardLines;
	}
}
