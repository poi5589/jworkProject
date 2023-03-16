package com.mj.jwork.ess.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mj.jwork.common.model.vo.PageInfo;
import com.mj.jwork.common.template.Pagination;
import com.mj.jwork.employee.model.vo.Employee;
import com.mj.jwork.ess.model.service.EssServiceImpl;
import com.mj.jwork.ess.model.vo.Businesstrip;
import com.mj.jwork.ess.model.vo.Leave;
import com.mj.jwork.ess.model.vo.LeaveCategory;
import com.mj.jwork.ess.model.vo.Overtime;

@Controller
public class EssController {

	@Autowired
	private EssServiceImpl eService;

	/**
	 * 휴가메뉴창 띄우기
	 * @return
	 */
	@RequestMapping("menu.le")
	public String leaveMainPage() {
		return "ess/leaveMenu";
	}

	/**
	 * 휴가등록폼
	 * @param no
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("enrollForm.le")
	public ModelAndView selectLeaveCategory(int no, HttpSession session, ModelAndView mv) {

		Employee e = (Employee) session.getAttribute("loginUser");
		LeaveCategory lc = eService.selectLeaveCategory(no);
		// System.out.println(lc);

		if (lc != null) {
			mv.addObject("lc", lc);
			mv.addObject("e", e);
			// session.setAttribute("loginUser", loginUser);
			mv.setViewName("ess/leaveEnrollForm");

		}

		return mv;
	}

	/**
	 * 휴가등록(insert)
	 * @param le
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("insert.le")
	public String insertLeave(Leave le, HttpSession session, Model model) {
		
		int result = eService.insertLeave(le);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "휴가등록이 완료되었습니다.");
			return "redirect:/list.le";
		}else {
			model.addAttribute("errorMsg", "휴가등록에 실패하였습니다.");
			return "common/errorPage";
		}
		
	}
	
	/**
	 * 휴가전체리스트/상세조회
	 * @param currentPage
	 * @param mv
	 * @return
	 */
	@RequestMapping("list.le")
	public ModelAndView selectLeave(@RequestParam(value="cpage", defaultValue="1") int currentPage, HttpSession session, ModelAndView mv) {
		
		Employee e = (Employee)session.getAttribute("loginUser");
		
		// 페이징
		int listCount = eService.selectLeaveListCount(e);
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5);
		
		// 페이징 후 게시글 전체조회
		ArrayList<Leave> list = eService.selectLeaveList(e, pi);
		
		mv.addObject("e", e);
		mv.addObject("pi", pi);
		mv.addObject("list", list);
		mv.setViewName("ess/leaveList");
		
		return mv;
	}
	
	/**
	 * 휴가상세조회
	 * @param le
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="detail.le", produces="application/json; charset=UTF-8")
	public String selectLeaveDetail(Leave le) {
		
		Leave leave = eService.selectLeaveDetail(le);
		return new Gson().toJson(leave);
	}
	
	/**
	 * 휴가삭제하기
	 * @param leaveNo
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("delete.le")
	public ModelAndView deleteLeave(@RequestParam(value="no") int leaveNo, HttpSession session, ModelAndView mv) {
		int result = eService.deleteLeave(leaveNo);
		if(result > 0) {
			session.setAttribute("alertMsg", "휴가등록 삭제에 성공하였습니다.");
			mv.setViewName("redirect:/list.le");
		}else {
			mv.addObject("errorMsg", "휴가등록 삭제에 실패하였습니다.");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping("adminList.le")
	public String adminLeaveList(@RequestParam(value="cpage", defaultValue="1") int currentPage, HttpSession session) {
		// 페이징
		int ListCount = eService.adminSelectLeaveListCount();
		PageInfo pi = Pagination.getPageInfo(ListCount, currentPage, 15, 5);
		
		ArrayList<Leave> list = eService.adminSelectLeaveList(pi);
		
		session.setAttribute("list", list);
		return "ess/adminLeaveList";
		
	}
	
	/**
	 * 시간외근무등록폼
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("enrollForm.ot")
	public ModelAndView overtimeEnrollForm(HttpSession session, ModelAndView mv) {
		
	
		Employee e = (Employee) session.getAttribute("loginUser");

		mv.addObject("e", e);
		mv.setViewName("ess/overtimeEnrollForm");
			
		return mv;
	}
	
	/**
	 * 출장등록폼
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("enrollForm.bt")
	public ModelAndView businesstripEnrollForm(HttpSession session, ModelAndView mv) {
		
		Employee e = (Employee)session.getAttribute("loginUser");

		mv.addObject("e", e);
		mv.setViewName("ess/businesstripEnrollForm");
			
		return mv;
	}
	
	/**
	 * 시간외근무등록신청(insert)
	 * @return
	 */
	@RequestMapping("insert.ot")
	public String insertOvertime(Overtime o, HttpSession session, Model model) {
		
		int result = eService.insertOvertime(o);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "시간외 근무등록이 완료되었습니다.");
			return "redirect:/list.wt";
		}else {
			model.addAttribute("errorMsg", "시간외 근무등록에 실패하였습니다.");
			return "common/errorPage";
		}
		
	}
	
	/**
	 * 시간외근무신청 삭제
	 * @param otNo
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.ot")
	public String deleteOvertime(int otNo, HttpSession session, Model model) {
		int result = eService.deleteOvertime(otNo);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "시간외 근무신청이 삭제되었습니다.");
			return "redirect:/list.wt";
		}else {
			model.addAttribute("errorMsg", "시간외 근무신청 삭제에 실패하였습니다.");
			return "common/errorPage";
		}
	}
	
	/**
	 * 출장등록신청(insert)
	 * @return
	 */
	@RequestMapping("insert.bt")
	public String insertBusinesstrip(Businesstrip b, HttpSession session, Model model) {
		
		int result = eService.insertBusinesstrip(b);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "출장등록이 완료되었습니다.");
			return "redirect:/list.wt";
		}else {
			model.addAttribute("errorMsg", "출장등록에 실패하였습니다.");
			return "common/errorPage";
		}
		
	}
	
	/**
	 * 출장등록삭제
	 * @param btNo
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.bt")
	public String deleteBusinesstrip(int btNo, HttpSession session, Model model) {
		int result = eService.deleteBusinesstrip(btNo);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "출장신청이 삭제되었습니다.");
			return "redirect:/list.wt";
		}else {
			model.addAttribute("errorMsg", "출장신청삭제에 실패하였습니다.");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("list.wt")
	public ModelAndView selectEnrollList(HttpSession session, ModelAndView mv) {
		
		Employee e = (Employee)session.getAttribute("loginUser");
		mv.addObject("e", e);
		mv.setViewName("ess/workingEnrollList");
		
		return mv;
	}
	
	/**
	 * ajax 출장조회
	 * @param currentPage
	 * @param empNo
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="list.bt", produces="application/json; charset=UTF-8")
	public String ajaxSelectBusinesstripList(@RequestParam(value="bpage", defaultValue="1") int currentPage, int empNo, HttpSession session) {
		
		// 페이징
		int bListCount = eService.selectBusinesstripListCount(empNo);
		PageInfo bPi = Pagination.getPageInfo(bListCount, currentPage, 5, 5);
		
		// 페이징 후 게시글조회
		ArrayList<Businesstrip> bList = eService.selectBusinesstripList(empNo, bPi);
		
		HashMap<String, Object> bmap = new HashMap();
		bmap.put("bListCount", bListCount);
		bmap.put("bPi", bPi);
		bmap.put("bList", bList);
		
		return new Gson().toJson(bmap);
	}
	
	/**
	 * ajax 시간외근무 조회
	 * @param currentPage
	 * @param empNo
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="list.ot", produces="application/json; charset=UTF-8")
	public String ajaxSelectOvertimeList(@RequestParam(value="opage", defaultValue="1") int currentPage, int empNo, HttpSession session) {
		
		// 페이징
		int oListCount = eService.selectOvertimeListCount(empNo);
		PageInfo oPi = Pagination.getPageInfo(oListCount, currentPage, 5, 5);
		
		// 페이징 후 게시글조회
		ArrayList<Overtime> oList = eService.selectOvertimeList(empNo, oPi);
		
		HashMap<String, Object> omap = new HashMap();
		omap.put("oListCount", oListCount);
		omap.put("oPi", oPi);
		omap.put("oList", oList);
		
		return new Gson().toJson(omap);
		
	}
	
	@RequestMapping("detail.bt")
	public ModelAndView selectBusinesstrip(int btNo, ModelAndView mv) {
		Businesstrip b = eService.selectBusinesstrip(btNo);
		
		mv.addObject("b", b);
		mv.setViewName("ess/businesstripDetailForm");
		
		return mv;
	}
	
	@RequestMapping("detail.ot")
	public ModelAndView selectOvertime(int otNo, ModelAndView mv) {
		
		Overtime o = eService.selectOvertime(otNo);
		
		mv.addObject("o", o);
		mv.setViewName("ess/overtimeDetailForm");
		
		return mv;
	}
	
	
	/**
	 * 관리자 : 출장등록조회
	 * @return
	 */
	@RequestMapping("admin.bt")
	public String adminBusinesstripList(@RequestParam(value="cpage", defaultValue="1") int currentPage, HttpSession session, Model model) {
		
		int jobCode = ((Employee)session.getAttribute("loginUser")).getJobCode();
		if(jobCode == 6 || jobCode == 7) {
			model.addAttribute("errorMsg", "접근 권한이 없습니다.");
			return "common/errorPage";
		}else {
			// 페이징
			int listCount = eService.adminSelectBusinesstripListCount();
			PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 5, 15);
			
			ArrayList<Businesstrip> list = eService.adminSelectBusinesstripList(pi);
			
			session.setAttribute("list", list);
			session.setAttribute("pi", pi);
			return "ess/adminBusinesstripList";
		}
		
	}
	
	/**
	 * 관리자 : 출장상세조횐
	 * @param btNo
	 * @param mv
	 * @return
	 */
	@RequestMapping("adDetail.bt")
	public ModelAndView adminSelectBusinesstrip(int btNo, ModelAndView mv) {
		Businesstrip b = eService.adminSelectBusinesstrip(btNo);
		
		mv.addObject("b", b);
		mv.setViewName("ess/adminBusinesstripDetailView");
		
		return mv;
	}
	
	/**
	 * 관리자 : 시간외근무조회
	 * @return
	 */
	@RequestMapping("admin.ot")
	public ModelAndView adminOvertimeList(@RequestParam(value="cpage", defaultValue="1") int currentPage, HttpSession session, ModelAndView mv) {
		
		int jobCode = ((Employee)session.getAttribute("loginUser")).getJobCode();
		
		if(jobCode == 6 || jobCode == 7) {
			mv.addObject("errorMsg", "접근권한이 없습니다.");
			mv.setViewName("common/errorPage");
		}else {
			// 페이징
			int listCount = eService.adminSelectOvertimeListCount();
			PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 5, 15);
			
			ArrayList<Overtime> list = eService.adminSelectOvertimeList(pi);
			
			mv.addObject("list", list);
			mv.addObject("pi", pi);
			mv.setViewName("ess/adminOvertimeList");
		}
		
		return mv;
	}
	
	/**
	 * 관리자 : 시간외근무상세조회
	 * @param otNo
	 * @param mv
	 * @return
	 */
	@RequestMapping("adDetail.ot")
	public ModelAndView adminSelectOvertime(int otNo, ModelAndView mv) {
		Overtime o = eService.adminSelectOvertime(otNo);
		
		mv.addObject("o", o);
		mv.setViewName("ess/adminOvertimeDetailView");
		
		return mv;
	}
	
	/**
	 * 관리자 : 출장결재선 1차,2차
	 * @param b
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping("adminUpdate.bt")
	public ModelAndView adminUpdateBusinesstrip(Businesstrip b, HttpSession session, ModelAndView mv) {
		
		int jobCode = ((Employee)session.getAttribute("loginUser")).getJobCode();
		
		if(jobCode == 4 || jobCode == 5) {
			int result = eService.adminUpdateFirstBusinesstrip(b);
			if(result > 0) {
				mv.addObject("alertMsg", "결재선등록이 완료되었습니다.");
				mv.setViewName("admin.bt");
				
			}else {
				mv.addObject("errorMsg", "결재선등록에 실패하였습니다.");
				mv.setViewName("common/errorPage");
			}
		}else if(jobCode == 3 || jobCode == 2) {
			int result = eService.adminUpdateSecondBusinesstrip(b);
			if(result > 0) {
				mv.addObject("alertMsg", "결재선등록이 완료되었습니다.");
				mv.setViewName("admin.bt");
			}else {
				mv.addObject("errorMsg", "결재선등록에 실패하였습니다.");
				mv.setViewName("common/errorPage");
			}
		}
		
		return mv;
	}
	
	@RequestMapping("adminUpdate.ot")
	public ModelAndView adminUpdateOvertime(Overtime o, HttpSession session, ModelAndView mv) {
		
		int jobCode = ((Employee)session.getAttribute("loginUser")).getJobCode();
		
		if(jobCode == 4 || jobCode == 5) {
			int result = eService.adminUpdateFirstOvertime(o);
			if(result > 0) {
				mv.addObject("alertMsg", "결재선등록이 완료되었습니다.");
				mv.setViewName("admin.ot");
				
			}else {
				mv.addObject("errorMsg", "결재선등록에 d실패하였습니다.");
				mv.setViewName("common/errorPage");
			}
		}else if(jobCode == 3 || jobCode == 2) {
			int result = eService.adminUpdateSecondOvertime(o);
			if(result > 0) {
				mv.addObject("alertMsg", "결재선등록이 완료되었습니다.");
				mv.setViewName("admin.ot");
			}else {
				mv.addObject("errorMsg", "결재선등록에 실패하였습니다.");
				mv.setViewName("common/errorPage");
			}
		}
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
