import React, { useState,useEffect } from 'react';
import '../../styles/MatchingPage/Wait/waitingPage.css';
import axiosInstance from "../axiosInstance";
import MatchResult from "./MatchResult";

const MatchWait = ({ session, party,setParty,setIsMatch }) => {
    const [matchStatus, setMatchStatus] = useState('');
    const [partyData, setPartyData] = useState(null);
    const [matchAccept, setmatchAccept] = useState(false); // 추가된 부분
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
    const handleAccept = () => {
        setmatchAccept(true);
    };


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
    const cancel=()=>{
        axiosInstance.post("/matchGetIt/match/cancel",null,{
            params:{
                id:session.userId
            }
        }).then(response=>{
            // setMatchStatus('취소 성공');
            setMatchStatus('');
            setParty(null);
            setIsMatch(false);
        }).catch(error=>{
            setMatchStatus('취소 실패');
            setTimeout(() => {
                setMatchStatus('');
            }, 3000);
        });
    }

    return (
        <div className="waitContainer">
            {!matchAccept ? (
                    <div className="waitTitle">
                        {session.name} 님 매칭 중
                    </div>)
                :(<div className="waitTitle">
                    {session.name} 수락완료
                    <br/> 다른 인원 수락 대기중
                </div>)
            }
            <div className="waitAddress">{partyData?.address}</div>
            <div className="waitTime">{applicationTimeText}</div>
            <div className="Team">Team</div>
            <ul>
                {party.map((item, index) => (
                    <li key={index}>
                        <div className="TeamMember">{item.name}</div>
                    </li>
                ))}
            </ul>
            <p>{matchStatus}</p>
            {matchStatus || matchAccept? (
                <button type="button" className="glassBtn" onClick={cancel}>
                    매칭 취소
                </button>
            ) : (
                <div>
                    {matchAccept ? <MatchResult /> : null}
                    <button type="button" className="glassBtn" onClick={handleAccept}>
                        수락
                    </button>
                    <button type="button" className="glassBtn" onClick={cancel}>
                        거절
                    </button>
                </div>
            )}
        </div>
    );
};

export default MatchWait;