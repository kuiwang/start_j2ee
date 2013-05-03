package com.xuyuan.spring3.recipes.mvc.web.views;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.xuyuan.spring3.recipes.mvc.domain.Reservation;

public class PdfReservationSummary extends AbstractPdfView { 
    protected void buildPdfDocument(Map model, Document document, 
            PdfWriter writer, HttpServletRequest request, 
            HttpServletResponse response) throws Exception { 
        List<Reservation> reservations = (List) model.get("reservations"); 
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        Table table = new Table(5); 
        table.addCell("Court Name"); 
        table.addCell("Date"); 
        table.addCell("Hour"); 
        table.addCell("Player Name"); 
        table.addCell("Player Phone"); 
        for (Reservation reservation : reservations) { 
            table.addCell(reservation.getCourtName()); 
            table.addCell(dateFormat.format(reservation.getDate())); 
            table.addCell(Integer.toString(reservation.getHour())); 
            table.addCell(reservation.getPlayer().getName()); 
            table.addCell(reservation.getPlayer().getPhone()); 
        } 
        document.add(table); 
    }
}