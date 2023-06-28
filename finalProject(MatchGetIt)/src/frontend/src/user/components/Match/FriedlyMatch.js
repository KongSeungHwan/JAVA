import React, {useEffect, useRef, useState} from 'react';
import '../../styles/MatchingPage/Application/friendlyMatching.css';
import '../../styles/CommonFactor/radioButton.css';
import axiosInstance from '../axiosInstance';
import AddressSearch from "./AddressSearch";

function FriendlyMatch({ session }) {
    const [party, setParty] = useState([]);
    const [searchStatus, setSearchStatus] = useState('');
    const [addressVisible, setAddressVisible] = useState(false);
    const [id, setId] = useState('');
    const [address, setAddress] = useState('');
    const [selectedDate, setSelectedDate] = useState('');
    const [selectedTime, setSelectedTime] = useState('A');
    const [x,setX]=useState('');
    const [y,setY]=useState('');
    const datePickerRef = useRef(null);
    useEffect( ()=>{
        const today = new Date();
        today.setDate(today.getDate() + 3);
        const formattedDate = today.toISOString().substr(0, 10);

        datePickerRef.current.min = formattedDate;
    })

    const handleInputChange = (event) => {
        setId(event.target.value);
    };

    const searchId = () => {
        if(session.userId!=id){
            axiosInstance
            .post('/matchGetIt/partyAccept/searchId', null, { params: { id: id, partyLeaderId:session.userId } })
            .then((response) => {
                const memberExists = party.find(
                    (member) => member.userId === response.data.userId
                );
                console.log(response.data);
                if (memberExists) {
                    setSearchStatus('이미 추가된 파티원입니다.');
                }else if (response.data == null) {
                    setSearchStatus('존재하지 않는 계정입니다.');
                } else {
                    setParty([...party, response.data]);
                    setSearchStatus('파티 초대 성공(수락 필요)');
                }
                setTimeout(() => {
                    setSearchStatus('');
                }, 3000);
            })
            .catch((error) => {
                setSearchStatus('없는 파티원이거나 권한이 없다');
            });
    }else{
            setSearchStatus('본인 아이디는 추가 못함');
            setTimeout(() => {
                setSearchStatus('');
            }, 3000);
        }
        };
    const renewData= ()=>{
        axiosInstance
            .post('/matchGetIt/partyAccept/renewPartyAcceptData', null, { params: {partyLeaderId:session.userId}})
            .then((response) => {
                setParty(response.data);
            }).catch((error) => {
            setSearchStatus('갱신 실패');
            setTimeout(() => {
                setSearchStatus('');
            }, 3000);
        });

    }

    const submitMatch = () => {
        const agreement = party.filter(member=>member.agreement!='AGREE');
        if(agreement.length==0){
        if(address&&selectedDate&&x&&y){
            
        const partyMembers = party.map((member) => ({ id: member.user.userId }));
        const requestData = {
            partyLeader: session.userId,
            address: address,
            x: x,
            y: y,
            selectedDate: selectedDate,
            selectedTime: selectedTime,
            party: partyMembers,
            gameType:'FRIENDLY'
        };

            axiosInstance
            .post('/matchGetIt/match/start', requestData)
            .then((response) => {
                    window.location.reload();
                    setSearchStatus('성공');
                setTimeout(() => {
                    setSearchStatus('');
                }, 3000);
                console.log('성공');
            })
            .catch((error) => {
                setSearchStatus('실패');
                setTimeout(() => {
                    setSearchStatus('');
                }, 3000);
            });
        }else{
            setSearchStatus('입력하지 않은 정보가 존재(재확인)');
            setTimeout(() => {
                setSearchStatus('');
            }, 3000);
        }
        }else{
            setSearchStatus('수락하지 않은 파티원이 있습니다');
            setTimeout(() => {
                setSearchStatus('');
            }, 3000);
        }
    };
    const onSelectAddress = (address, x, y) => {
        setAddress(address);
        setX(x);
        setY(y);
        console.log(address+'위도:'+x+'경도:'+y);

    };

    const deleteId = (index) => {
        const updatedParty = [...party];
        updatedParty.splice(index, 1);
        setParty(updatedParty);

    };

    return (
        <div className="applicationContainer fContainer">
            <div className="matchingTitle fTitle">Friendly Match</div>
            <form>
                <div className="address">
                    <div className="fSubTitle subTitle addressTitle">선택한 지역</div>
                    <input
                        type="text"
                        className="fInputData inputData"
                        readOnly
                        required
                        value={address}
                        onClick={() => setAddressVisible(true)}
                        placeholder="주소 검색"
                    />
                    <AddressSearch visible={addressVisible} setVisible={setAddressVisible} onSelect={onSelectAddress} />
                </div>
                <div className="time">
                    <div className="fSubTitle subTitle timeTitle">선택 시간</div>
                    <input
                        type="date"
                        className="timeSelect mDate"
                        value={selectedDate}
                        onChange={(event) => setSelectedDate(event.target.value)}
                        ref={datePickerRef}
                    />
                    <select
                        className="mTime"
                        value={selectedTime}
                        onChange={(event) => setSelectedTime(event.target.value)}
                    >
                        <option value="A">오전 10시~오후 12시</option>
                        <option value="B">오후 12시~오후 2시</option>
                        <option value="C">오후 2시~오후 4시</option>
                        <option value="D">오후 4시~오후 6시</option>
                        <option value="E">오후 6시~오후 8시</option>
                        <option value="F">오후 8시~오후 10시</option>
                    </select>
                </div>
                <div className="party">
                    <div className="fSubTitle subTitle partyTitle">같이 할 파티원</div>

                    <input
                        type="text"
                        className="fInputData inputMatchData"
                        value={id}
                        onChange={handleInputChange}
                        placeholder="같이 할 유저의 id 입력!"
                    />
                    <span className="systemMessage">{searchStatus}</span>
                    <button className="mBtn fButton pBtn" type="button" onClick={searchId}>
                        파티원 추가
                    </button>
                    <div className="partyList">
                        {party.map((member, index) => (
                            <div key={index}>
                                <div className="Pname">{member.name}</div>
                                <div className="Pname">{member.agreement === 'AGREE' ? (
                                    <div style={{ color: 'green' }}>수락</div>
                                ) : member.agreement === 'DISAGREE' ? (
                                    <div style={{ color: 'red' }}>거절</div>
                                ) : (
                                    <div style={{ color: 'gray' }}>대기</div>
                                )}</div>
                                <div className="deleteBtnArea">
                                    <button
                                        className="mBtn fButton deleteBtn"
                                        type="button"
                                        onClick={() => deleteId(index)}
                                    >
                                        삭제
                                    </button>
                                </div>
                            </div>
                        ))}
                    </div>
                    <button className="mBtn fButton pBtn" type="button" onClick={renewData}>
                        수락여부 갱신
                    </button>
                </div>
                <button className="mBtn fButton pointBtn" type="button">
                    {session.name}님 잔여 포인트 : {session.ownedPoint}
                </button>
                <button className="mBtn fButton mSubBtn" type="button" onClick={submitMatch}>
                    매칭
                </button>
            </form>
        </div>
    );
}

export default FriendlyMatch;