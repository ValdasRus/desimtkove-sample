package utils;

import model.AthleteModel;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

public class FormXml {

    private Document document;

    public void getXmlDocumentFormed(List<AthleteModel> athleteList) {
        try {
            Document doc = getNewDocument();

            Element participantsRoot = doc.createElement("participants");
            doc.appendChild(participantsRoot);

            for (AthleteModel athlete : athleteList) {
                Element participant = doc.createElement("participant");
                participantsRoot.appendChild(participant);

                Attr attr = doc.createAttribute("name");
                attr.setValue(athlete.getName());
                participant.setAttributeNode(attr);

                Element position = doc.createElement("position");
                position.appendChild(doc.createTextNode(String.valueOf(athlete.getNewPosition())));
                participant.appendChild(position);

                Element totalPoints = doc.createElement("totalPoints");
                totalPoints.appendChild(doc.createTextNode(String.valueOf(athlete.getTotalPoints())));
                participant.appendChild(totalPoints);


                Element running100m = doc.createElement("running100m");
                participant.appendChild(running100m);

                Element result = doc.createElement("result");
                result.appendChild(doc.createTextNode(String.valueOf(athlete.getRunning100mInput())));
                running100m.appendChild(result);

                Element points = doc.createElement("points");
                points.appendChild(doc.createTextNode(String.valueOf(athlete.getRunning100m())));
                running100m.appendChild(points);


                Element longJump = doc.createElement("longJump");
                participant.appendChild(longJump);

                Element resultL = doc.createElement("result");
                resultL.appendChild(doc.createTextNode(String.valueOf(athlete.getLongJumpInput())));
                longJump.appendChild(resultL);

                Element pointsL = doc.createElement("points");
                pointsL.appendChild(doc.createTextNode(String.valueOf(athlete.getLongJump())));
                longJump.appendChild(pointsL);


                Element shortPut = doc.createElement("shortPut");
                participant.appendChild(shortPut);

                Element resultSP = doc.createElement("result");
                resultSP.appendChild(doc.createTextNode(String.valueOf(athlete.getShortPutInput())));
                shortPut.appendChild(resultSP);

                Element pointsSP = doc.createElement("points");
                pointsSP.appendChild(doc.createTextNode(String.valueOf(athlete.getShortPut())));
                shortPut.appendChild(pointsSP);


                Element highJump = doc.createElement("highJump");
                participant.appendChild(highJump);

                Element resultHJ = doc.createElement("result");
                resultHJ.appendChild(doc.createTextNode(String.valueOf(athlete.getHighJumpInput())));
                highJump.appendChild(resultHJ);

                Element pointsHJ = doc.createElement("points");
                pointsHJ.appendChild(doc.createTextNode(String.valueOf(athlete.getHighJump())));
                highJump.appendChild(pointsHJ);


                Element running400 = doc.createElement("running400");
                participant.appendChild(running400);

                Element result400 = doc.createElement("result");
                result400.appendChild(doc.createTextNode(String.valueOf(athlete.getRunning400mInput())));
                running400.appendChild(result400);

                Element points400 = doc.createElement("points");
                points400.appendChild(doc.createTextNode(String.valueOf(athlete.getRunning400m())));
                running400.appendChild(points400);


                Element hurdles = doc.createElement("hurdles");
                participant.appendChild(hurdles);

                Element resultHur = doc.createElement("result");
                resultHur.appendChild(doc.createTextNode(String.valueOf(athlete.getHurdlesInput())));
                hurdles.appendChild(resultHur);

                Element pointsHur = doc.createElement("points");
                pointsHur.appendChild(doc.createTextNode(String.valueOf(athlete.getHurdles())));
                hurdles.appendChild(pointsHur);


                Element discusThrow = doc.createElement("discusThrow");
                participant.appendChild(discusThrow);

                Element resultD = doc.createElement("result");
                resultD.appendChild(doc.createTextNode(String.valueOf(athlete.getDiscusThrowInput())));
                discusThrow.appendChild(resultD);

                Element pointsD = doc.createElement("points");
                pointsD.appendChild(doc.createTextNode(String.valueOf(athlete.getDiscusThrow())));
                discusThrow.appendChild(pointsD);


                Element poleVault = doc.createElement("poleVault");
                participant.appendChild(poleVault);

                Element resultP = doc.createElement("result");
                resultP.appendChild(doc.createTextNode(String.valueOf(athlete.getPoleVaultInput())));
                poleVault.appendChild(resultP);

                Element pointsP = doc.createElement("points");
                pointsP.appendChild(doc.createTextNode(String.valueOf(athlete.getPoleVault())));
                poleVault.appendChild(pointsP);


                Element javelinThrow = doc.createElement("javelinThrow");
                participant.appendChild(javelinThrow);

                Element  resultJT= doc.createElement("result");
                resultJT.appendChild(doc.createTextNode(String.valueOf(athlete.getJavelinThrowInput())));
                javelinThrow.appendChild(resultJT);

                Element pointsJT = doc.createElement("points");
                pointsJT.appendChild(doc.createTextNode(String.valueOf(athlete.getJavelinThrow())));
                javelinThrow.appendChild(pointsJT);


                Element running1500m = doc.createElement("running1500m");
                participant.appendChild(running1500m);

                Element  result1500m= doc.createElement("result");
                result1500m.appendChild(doc.createTextNode(String.valueOf(athlete.getRunning1500mInput())));
                running1500m.appendChild(result1500m);

                Element points1500m = doc.createElement("points");
                points1500m.appendChild(doc.createTextNode(String.valueOf(athlete.getRunning1500m())));
                running1500m.appendChild(points1500m);

            }
            setDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Document getNewDocument() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.newDocument();

    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
