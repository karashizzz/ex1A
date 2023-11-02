package com.company.Control;

import com.company.Model.HandlerInfo;
import com.company.Utils.FilterUtils;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class Handler<Object> implements PcapPacketHandler<Object> {
    FilterUtils filterUtils;
    @Override
    public void nextPacket(PcapPacket packet, Object handlerInfo) {
        HandlerInfo Info = (HandlerInfo) handlerInfo;
        if (packet != null) {
            //抓到的所有包都放入
            Info.packetlist.add(packet);
            //符合条件的包放入
            if(filterUtils.IsFilter(packet, Info.FilterProtocol, Info.FilterSrcip, Info.FilterDesip, Info.FilterKey)&&
            filterUtils.Istrace(packet, Info.TraceIP, Info.TracePort)){
                Info.analyzePacketlist.add(packet);
                Info.showTable(packet);
            }
            System.out.println(packet);
        }
    }
}
