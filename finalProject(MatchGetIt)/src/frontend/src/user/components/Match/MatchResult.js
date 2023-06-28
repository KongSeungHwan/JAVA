import React, { useState,useEffect } from 'react';
import '../../styles/MatchingPage/Wait/waitingPage.css';
import axiosInstance from "../axiosInstance";

const MatchResult = ({ session, party,team,setParty,setIsMatch }) => {
    const [partyData, setPartyData] = useState(null);
    useEffect(() => {
        findPartyData();
    });

    const findPartyData = () => {
        axiosInstance
            .post('/matchGetIt/match/getParty', null, { params: { id: session.userId } })
            .then((response) => {
                if (response.data.length !== 0) {
                    console.log(response.data);
                    setPartyData(response.data);
                }
            })
            .catch((error) => {
                console.log('파티 없음 또는 서버오류');
            });
    }



    if (party === null) {
        return (
            <>잘못된 접근입니다.</>
        );
    }

    // applicationTime에 따라 한글로 표현
    let applicationTimeText = '';
    switch (party?.applicationTime) {
        case 'A':
            applicationTimeText = '오전 10시 ~ 오후 12시';
            break;
        case 'B':
            applicationTimeText = '오후 12시 ~ 오후 2시';
            break;
        case 'C':
            applicationTimeText = '오후 2시 ~ 오후 4시';
            break;
        case 'D':
            applicationTimeText = '오후 4시 ~ 오후 6시';
            break;
        case 'E':
            applicationTimeText = '오후 6시 ~ 오후 8시';
            break;
        case 'F':
            applicationTimeText = '오후 8시 ~ 오후 10시';
            break;
        default:
            applicationTimeText = '';
            break;
    }

    return (
        <div className="resultContainer">
            <div className="resultStatiumimg">Statium img link</div>
            <div className="resultTime">{applicationTimeText}</div>
            <div className="resultStadium">매칭구장 : 구장이름</div>
            <div className="lineUp">LINE_UP</div>
            <div className="aTeam">
                <div className="uniform"><img src="public/images/uniformA.png" alt="Ateam"/></div>
                <div className="resultMember">
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                </div>
            </div>
            <div className="bTeam">
                <div className="uniform"><img src="public/images/uniformB.png" alt="Bteam"/></div>
                <div className="resultMember">
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                    <div>memberName, Class</div>
                </div>
            </div>
            <ul>
                {party.map((item, index) => (
                    <li key={index}>
                        <div className="TeamMember">{item.name}</div>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default MatchResult;