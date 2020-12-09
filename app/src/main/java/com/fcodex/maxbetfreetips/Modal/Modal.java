package com.fcodex.maxbetfreetips.Modal;

import com.fcodex.maxbetfreetips.API.API;

public class Modal {

    // Free Tips Modal

    int freeTipsId;
    String freeTipsDate;
    String freeTipsLeagueTime;
    String freeTipsLeagueName;
    String freeTipsTeam1;
    String freeTipsTeam1Goal;
    String freeTipsTeam2Goal;
    String freeTipsTeam2;
    String freeTipsPrediction;
    String freeTipsOdds;
    String freeTipsPercentage;
    String freeTipsWinLoss;

    // Vip Tips Modal
    int vipId;
    String vipDate;
    String vipTitle;
    String vipLink;
    String vipDescription;
    String vipImage;

    // Free Tips Modal Getter Setters

    public int getFreeTipsId() {
        return freeTipsId;
    }

    public void setFreeTipsId(int freeTipsId) {
        this.freeTipsId = freeTipsId;
    }

    public String getFreeTipsDate() {
        return freeTipsDate;
    }

    public void setFreeTipsDate(String freeTipsDate) {
        this.freeTipsDate = freeTipsDate;
    }

    public String getFreeTipsLeagueName() {
        return freeTipsLeagueName;
    }

    public void setFreeTipsLeagueName(String freeTipsLeagueName) {
        this.freeTipsLeagueName = freeTipsLeagueName;
    }

    public String getFreeTipsLeagueTime() {
        return freeTipsLeagueTime;
    }

    public void setFreeTipsLeagueTime(String freeTipsLeagueTime) {
        this.freeTipsLeagueTime = freeTipsLeagueTime;
    }

    public String getFreeTipsTeam1() {
        return freeTipsTeam1;
    }

    public void setFreeTipsTeam1(String freeTipsTeam1) {
        this.freeTipsTeam1 = freeTipsTeam1;
    }

    public String getFreeTipsTeam1Goal() {
        return freeTipsTeam1Goal;
    }

    public void setFreeTipsTeam1Goal(String freeTipsTeam1Goal) {
        this.freeTipsTeam1Goal = freeTipsTeam1Goal;
    }

    public String getFreeTipsTeam2Goal() {
        return freeTipsTeam2Goal;
    }

    public void setFreeTipsTeam2Goal(String freeTipsTeam2Goal) {
        this.freeTipsTeam2Goal = freeTipsTeam2Goal;
    }

    public String getFreeTipsTeam2() {
        return freeTipsTeam2;
    }

    public void setFreeTipsTeam2(String freeTipsTeam2) {
        this.freeTipsTeam2 = freeTipsTeam2;
    }

    public String getFreeTipsPrediction() {
        return freeTipsPrediction;
    }

    public void setFreeTipsPrediction(String freeTipsPrediction) {
        this.freeTipsPrediction = freeTipsPrediction;
    }

    public String getFreeTipsOdds() {
        return freeTipsOdds;
    }

    public void setFreeTipsOdds(String freeTipsOdds) {
        this.freeTipsOdds = freeTipsOdds;
    }

    public String getFreeTipsPercentage() {
        return freeTipsPercentage;
    }

    public void setFreeTipsPercentage(String freeTipsPercentage) {
        this.freeTipsPercentage = freeTipsPercentage;
    }

    public String getFreeTipsWinLoss() {
        return freeTipsWinLoss;
    }

    public void setFreeTipsWinLoss(String freeTipsWinLoss) {
        this.freeTipsWinLoss = freeTipsWinLoss;
    }

    // Vip Tips Modal Getter Setters

    public int getVipId() {
        return vipId;
    }

    public void setVipId(int vipId) {
        this.vipId = vipId;
    }

    public String getVipDate() {
        return vipDate;
    }

    public void setVipDate(String vipDate) {
        this.vipDate = vipDate;
    }

    public String getVipTitle() {
        return vipTitle;
    }

    public void setVipTitle(String vipTitle) {
        this.vipTitle = vipTitle;
    }

    public String getVipLink() {
        return vipLink;
    }

    public void setVipLink(String vipLink) {
        this.vipLink = vipLink;
    }

    public String getVipDescription() {
        return vipDescription;
    }

    public void setVipDescription(String vipDescription) {
        this.vipDescription = vipDescription;
    }

    public String getVipImage() {
        return API.VIP_IMAGE_BASE_URL + vipImage;
    }

    public void setVipImage(String vipImage) {
        this.vipImage = vipImage;
    }

}
